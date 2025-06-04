
## Spring 단계별 실습

---

### 1단계: IoC 컨테이너 기본 이해

* 목표: `ApplicationContext` 사용법, `Bean` 등록 및 가져오기 이해
* 실습 내용:

    * XML 설정 방식으로 객체 등록 (`GenericXmlApplicationContext`)
    * Java Config 방식으로 객체 등록 (`AnnotationConfigApplicationContext`)
    * 공통 코드: `MemberDTO` 클래스 만들어서 빈으로 등록 후 getBean()으로 꺼내보기

---

### 2단계: Bean 등록 방식 비교

* 목표: 3가지 방식(XML, JavaConfig, Annotation)의 차이 이해
* 실습 내용:

    * 동일한 `MemberDAO` 클래스를 3가지 방식으로 각각 등록하고 가져오기

        * XML `<bean>`
        * Java Config의 `@Bean`
        * 어노테이션 기반의 `@Component`, `@ComponentScan`

---

### 3단계: 의존성 주입(DI) 방식 비교

* 목표: 필드, setter, 생성자 주입의 차이 이해
* 실습 내용:

    * `Account` 인터페이스와 `PersonalAccount` 구현체 생성
    * `MemberDTO`에서 해당 객체를 DI로 주입

        * 필드 주입(@Autowired)
        * Setter 주입(@Autowired)
        * 생성자 주입(@Autowired 또는 생략 가능)

---

### 4단계: DI 세부 설정 - @Qualifier, @Primary, 컬렉션

* 목표: 주입 대상이 2개 이상일 때 우선순위 지정 방법 학습
* 실습 내용:

    * `Account`를 구현한 클래스 2개 생성 (`PersonalAccount`, `BusinessAccount`)
    * `@Primary`, `@Qualifier`를 활용해서 어떤 게 주입될지 컨트롤

---

### 5단계: Bean의 스코프와 생명주기

* 목표: Bean 생성 방식 및 생명주기 제어 방법 익히기
* 실습 내용:

    * Singleton vs Prototype 비교 (`@Scope`)
    * 초기화/소멸 메서드 테스트

        * `initMethod`, `destroyMethod`
        * `@PostConstruct`, `@PreDestroy`

---

### 6단계: properties 파일 연동

* 목표: 외부 설정 값을 Bean에 주입하는 방법 학습
* 실습 내용:

    * `application.properties` 또는 `.properties` 파일 생성
    * `@Value`, `@PropertySource`로 속성 읽기
