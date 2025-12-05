# SPRING ADVANCED
Spring 핵심 심화 개념을 직접 구현하며
ArgumentResolver, AOP 기반 로깅, N+1 문제 해결, 테스트 코드 품질 개선 등을 학습한 실습 프로젝트입니다.
<br/><br/>

## 👩🏻‍💻 기술 스택
- **Language**: Java 17
- **Framework**: Spring Boot 3.5
- **ORM**: Spring Data JPA
- **Database**: MySQL
- **Security / Auth**: Spring Security, JWT Filter
- **IDE**: IntelliJ IDEA
- **Build Tool**: Gradle
- **Test**: JUnit5, MockMvc, Postman
<br/>

## ⚙️ 구현 기능 및 리팩터링
### ArgumentResolver + WebMvcConfigurer 적용
- WebMvcConfigurer에 Argument Resolver 등록
  
### 코드 & 테스트 코드 리팩터링

### N+1 문제 해결 (@EntityGraph)
- Lazy Loading으로 발생하는 N+1 문제 -> @EntityGraph로 필요한 연관 엔티티만 즉시 로딩

### AOP 기반 API 로깅 구현
- @Around, @Pointcut 기반 AOP 로깅 적용
- Logging 항목: 요청 사용자 ID, 요청 시각, 요청 URI, 요청 Body, 응답 Body
- ContentCachingRequestWrapper로 Request/Response Body 재읽기 처리
- 전역 로깅 기능으로 Controller 중복 제거
<br/>

## 🤓 트러블슈팅 기록
[트러블슈팅 보러가기](https://remnantcjy.tistory.com/entry/%ED%8A%B8%EB%9F%AC%EB%B8%94%EC%8A%88%ED%8C%85)
