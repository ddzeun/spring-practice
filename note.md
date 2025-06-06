# Step 1
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

---
# Step 2

## DTO와 DAO를 xml 방식으로 등록할 때 

### DTO (`MemberDTO`)는 "데이터"를 담는 객체

* 즉, **필드(name, age)** 같은 **초기값**이 중요
* 그래서 XML에서 `constructor-arg`나 `property`로 초기값 필요

```xml
<bean id="member" class="com.zeun.common.MemberDTO">
    <constructor-arg name="name" value="지은" />
    <constructor-arg index="1" value="48329" />
</bean>
```

---

### DAO (`MemberDAO`)는 "동작"을 수행하는 객체

* 즉, **메서드(save 등)** 가 핵심이고, 내부 상태가 특별히 필요 없다.
* **필드가 없거나**, 필드에 외부 설정이 필요 없으면 빈 설정할 게 딱히 없음!
* 그래서 그냥 **기본 생성자만 호출해도 충분**

```xml
<bean id="memberDAO" class="com.zeun.common.MemberDAO" />
```

---

| 객체 종류 | 주요 관심사     | XML 설정 필요 여부                     |
| ----- | ---------- | -------------------------------- |
| DTO   | 데이터(필드 값)  | `constructor-arg`, `property` 필요 |
| DAO   | 동작(메서드 실행) | 없음 (기본 생성자만 있으면 충분)              |

---

### 그런데 DAO에 다른 Bean을 주입하려면?

예를 들어 DAO가 `MemberDTO`를 사용한다면?

```java
public class MemberDAO {
    private MemberDTO member;

    public void setMember(MemberDTO member) {
        this.member = member;
    }
}
```

이럴 땐 XML에서 의존성을 주입해야 함!

```xml
<bean id="memberDTO" class="com.zeun.common.MemberDTO">
    <constructor-arg name="name" value="두밤" />
    <constructor-arg index="1" value="28" />
</bean>

<bean id="memberDAO" class="com.zeun.common.MemberDAO">
    <property name="member" ref="memberDTO"/>
</bean>
```

**"빈에 어떤 값을 줄 필요가 있느냐"** 에 따라 XML 설정의 복잡도가 달라진다.

DAO는 단순하면 비워둬도 OK!
필드 주입이 필요해지면 그때 설정을 추가


## 
아하! 두밤이가 말한 **이름 자체에 담긴 의미**에 대해 궁금했던 거구나!
이건 아주 좋은 감각이고, 실무에서도 정말 중요한 습관이야.
그럼 두밤이의 `memberDAO`를 예시로, **이름을 어떻게 정하면 좋을지** 같이 보자!

---

## Bean 이름, 어떻게 지으면 좋을까?

### 1. **기능 기반으로 구체적이고 명확하게**

* 구체적인 역할이 있다면 이름이 붙여주는 것이 좋음

| Bean 이름           | 의미                                |
| ----------------- | --------------------------------- |
| `memberDAO`       | 회원 관련 데이터 접근 객체 (보통 기본 이름)        |
| `memberWriteDAO`  | 회원 데이터 **쓰기 전용** DAO              |
| `memberReadDAO`   | 회원 데이터 **읽기 전용** DAO              |
| `memberJdbcDAO`   | JDBC 방식 DAO (MyBatis나 JPA와 구분할 때) |
| `memberMemoryDAO` | 테스트용 메모리 DAO                      |
| `memberDAOImpl`   | 인터페이스 기반 구현체일 때 자주 사용             |

➡ 이름만 봐도 **무슨 역할인지 바로 떠오르도록!**

### 2. **상황에 따라 이름을 다르게 해도 OK**

* 예를 들어, 테스트용이면:

  ```java
  @Bean(name = "fakeMemberDAO")
  public MemberDAO testDAO() { ... }
  ```

* 혹은 특정 DB용이면:

  ```java
  @Bean(name = "mysqlMemberDAO")
  public MemberDAO dao() { ... }
  ```

즉, **기능 + 사용 환경**을 반영한 이름이 가장 베스트

완벽에 가까운 코드야 두밤아! 내용이 짧아 보여도 **Annotation 방식은 본질적으로 간결함을 목표로** 하기 때문에 전혀 이상하지 않아 😊 아래에 코드 피드백, 커밋 메시지, 그리고 세 방식 비교까지 다 정리해줄게!

---

## ✅ 코드 피드백

### 1. `@ComponentScan("com.zeun.step2.annotation")`

* ✔️ 올바르게 패키지를 지정해서 컴포넌트를 자동 탐색하게 했어.
* 🟡 이 경로에 여러 컴포넌트가 추가된다면 그들도 자동 등록될 거야. 구조를 잘 잡았어!

### 2. `@Component` 사용

* ✔️ `MemberDAO`를 `@Component`로 지정한 건 완벽.
* ❗ 클래스 명이 `MemberDAO`인데도 별도로 `@Component("memberDAO")`처럼 이름을 정하지 않아도 되는 이유는?
  👉 디폴트로 `memberDAO`라는 이름이 bean 이름으로 등록되기 때문이야! 하지만 명시하면 더 명확해지긴 해.

### 3. `Application` 클래스

* ✔️ `AnnotationConfigApplicationContext`를 통해 IoC 컨테이너 초기화하고, `getBean(MemberDAO.class)`로 타입 기반 조회를 잘 했어.
* ✅ `.save()` 메서드 호출까지 깔끔하게 완료!

---

## ✅ 커밋 메시지 추천 (영어)

### 기본형

```bash
feat: register MemberDAO using @Component and @ComponentScan
```

### 조금 더 자세히

```bash
feat: implement annotation-based bean registration with MemberDAO
```

### 실습 목적 강조

```bash
feat: demonstrate annotation-based bean configuration using @Component
```

---

## Bean을 등록하는 3가지 방식 비교

| 구분      | XML 방식      | Java Config              | Annotation 방식  |
| ------- | ------------- | -------------------------- | ------------- |
| 설정 위치   | XML 파일        | Java 클래스 (`@Configuration`) | 클래스 내부 (`@Component`) |
| 가독성/편의성 | ❌ 번거롭고 가독성 낮음 | ⭕ 명시적이지만 길 수 있음            | ⭕ 간단하고 자동화 쉬움 |
| 제어 수준       | ⭕ 완전 수동 설정 가능         | ⭕ 설정 명확                       | ❌ 자동 스캔으로 의존성 모호 가능 |
| 유지보수        | ❌ XML, 클래스 분리로 복잡도 증가 | ⭕한눈에 보기 좋아짐       | ⭕ 자동화로 유지관리 쉬움       |
| 용도 추천        | 옛 코드/레거시 프로젝트용       | 명시적인 설정이 필요한 경우      | 최근 트렌드, 간단한 앱에 적합   |


```txt
XML 방식은 모든 Bean을 XML에서 수동으로 등록하는 방식이라 명시적이고 구조화는 잘 되지만, 설정이 번거롭고 유지보수가 어렵습니다.

Java Config 방식은 자바 코드로 직접 Bean을 등록하며, 타입 안전성과 IDE 지원을 받을 수 있어 개발 편의성이 좋습니다.

Annotation 방식은 가장 간결하고 자동화된 방식으로, `@Component`나 `@Service` 등을 클래스에 붙이기만 하면 등록되므로 빠르게 개발할 수 있지만, Bean 이름이나 구조 파악이 어려울 수 있습니다.
```

---