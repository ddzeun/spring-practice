
### 3단계 목표: 의존성 주입 방식 비교

**목표: DI의 3가지 방식의 차이 이해하기**
필드 주입, Setter 주입, 생성자 주입 방식을 비교

---

### 실습 과제

#### 공통 전제

* `Notifier` 라는 인터페이스 생성
* `EmailNotifier` 클래스는 `Notifier`를 구현
* `User` 클래스는 `Notifier`를 의존성으로 가짐

---

#### DI 방식 1: 필드 주입

* `User` 클래스의 `Notifier` 필드에 `@Autowired` 직접 부착
* `setter`나 `생성자` 없이 바로 주입

#### DI 방식 2: Setter 주입

* `User` 클래스에 `setNotifier()` 메서드를 정의
* 해당 메서드에 `@Autowired` 부착

#### DI 방식 3: 생성자 주입

* `User` 클래스의 생성자에서 `Notifier`를 파라미터로 받음
* `@Autowired` 생략 가능 (단일 생성자일 경우)

---

### 실습 예시 설명

* `Notifier` 인터페이스에는 `send(String message)` 메서드 정의
* `EmailNotifier`는 `"이메일 전송: [message]"` 형식으로 출력
* `User`는 내부에서 `notifier.send("환영합니다!")` 호출

---

### 스스로 점검 기준

1. `User`에서 `Notifier`를 주입받는 방법 3가지를 모두 실습해보았는가?
2. Spring이 어떤 방식으로 객체를 자동 주입해주는지 이해했는가?
3. `User` 클래스가 `Notifier` 구현체에 직접 의존하지 않고 느슨하게 연결됐는가?
4. 테스트나 유지보수 측면에서 어떤 방식이 유리할지 고민해보았는가?
