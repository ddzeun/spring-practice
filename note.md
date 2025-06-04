
## Configuration 파일 이름은 어떻게 짓는 게 좋을까?

### Configuration 클래스 네이밍 컨벤션

| 네이밍 예시                                              | 설명                     |
| --------------------------------------------------- | ---------------------- |
| `AppConfig`                                         | 가장 일반적인 이름 (간단할 때)     |
| `ContextConfig`, `ContextConfiguration`             | 전체 컨텍스트 설정이 담긴 파일일 때   |
| `MemberConfig`, `ServiceConfig`, `RepositoryConfig` | 역할별로 설정 파일을 나눌 경우      |
| `Step1Config`, `XmlBeanConfig`, `JavaBeanConfig`    | 단계별 실습이나 샘플 코드일 경우도 있음 |




현재 구조상 실습용이니 `ContextConfiguration`도 👌
만약 기능이 나뉜다면 아래처럼 쪼개는 것도 가능:

* `MemberConfig` → MemberDTO 관련 설정
* `DatabaseConfig` → DB 관련 설정
* `WebConfig` → Spring MVC 관련 설정

---

* commit message

```bash
feat: configure bean using Java-based configuration
```

혹은 조금 더 구체적으로:

```bash
feat: add MemberDTO bean using @Configuration and @Bean
```
