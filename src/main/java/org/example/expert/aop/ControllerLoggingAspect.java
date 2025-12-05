package org.example.expert.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.nio.charset.StandardCharsets;
import java.time.LocalTime;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class ControllerLoggingAspect {

    private final ObjectMapper objectMapper;

    @Pointcut("execution(* org.example.expert.domain.user.controller.UserAdminController.*(..))")
    void userAdminController() {}

    @Pointcut("execution(* org.example.expert.domain.comment.controller.CommentAdminController.*(..))")
    void commentAdminController() {}

    @Around("userAdminController() || commentAdminController()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        ContentCachingRequestWrapper requestWrapper = (ContentCachingRequestWrapper) request;

        Object userId = request.getAttribute("userId");
        String requestURI = request.getRequestURI();
        LocalTime requestTime = LocalTime.now();

        String requestBody = new String(requestWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);

        log.info("------------ AOP 시작 ------------");
        log.info("요청 userId: {}", userId);
        log.info("요청 requestURI: {}", requestURI);
        log.info("요청 시각: {}", requestTime);
        log.info("요청 본문: {}", requestBody);

        Object response = joinPoint.proceed();

        String responseBody = objectMapper.writeValueAsString(response);

        log.info("응답 본문: {}", responseBody);
        log.info("------------ AOP 끝 ------------");

        return responseBody;
    }
}
