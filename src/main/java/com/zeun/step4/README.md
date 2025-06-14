### 4단계 목표: 우선순위 지정

**목표: 주입 대상이 2개 이상일 때 우선순위 지정 방법 학습하기**

---

## 실습 과제

### 공통 전제

* `Account` 라는 인터페이스 생성
* 이를 구현한 클래스 두 개 생성: `PersonalAccount`, `BusinessAccount`

### 실습 1: @Primary 사용

1. `Account`를 구현한 `PersonalAccount`, `BusinessAccount` 클래스 만들기
2. 두 구현 클래스 모두 `@Component`로 등록
3. 그중 하나에 `@Primary`를 추가해서 **기본 주입 대상** 지정
4. `User` 클래스는 `Account`를 주입받고, 어떤 구현체가 주입되는지 출력

### 실습 2: @Qualifier 사용

1. 위와 동일한 `PersonalAccount`, `BusinessAccount` 클래스 활용
2. `@Primary`는 제거
3. `User` 클래스에서 `@Qualifier("bean이름")`으로 명시적 주입
4. 어떤 구현체가 주입되는지 확인

### 실습 3: 컬렉션 주입

1. `User` 클래스가 `List<Account>` 타입으로 주입받도록 변경
2. 전체 구현체가 주입되는지 출력 확인
3. 순서대로 각 구현체의 `deposit()` 같은 메서드를 호출해보기

---

### 실습 예시 설명

* `Account`는 단순한 입금 인터페이스 (ex. `void deposit(int amount)` 같은 메서드)
* `PersonalAccount`, `BusinessAccount`는 각각 출력 메시지만 다르게 작성
* `@Primary`, `@Qualifier`, 컬렉션(List<Account>) 방식으로 주입 다르게 실습

---

### 실습 후 체크리스트

1. 인터페이스와 구현체 2개를 만들었는가?
2. `@Primary`로 기본 주입 대상 지정해봤는가?
3. `@Qualifier`로 명시적 주입을 시도해봤는가?
4. `List<Account>`로 모든 구현체를 주입해봤는가?
5. ApplicationContext로 객체 꺼내 실행해봤는가?
