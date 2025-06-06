## 2단계 목표: Bean 등록 방식 비교

**목표: 3가지 Bean 등록 방식의 차이 이해하기**
XML, Java Config, Annotation 기반의 등록 방식 비교

---

### 실습 목표

**같은 `MemberDAO` 클래스를 각각 다른 방법으로 등록하고, 컨테이너에서 가져와 사용해보자!**

---

### 실습 과제

#### 1. XML 방식 (`GenericXmlApplicationContext`)

* `MemberDAO` 클래스를 작성
* XML 설정 파일에 `<bean>` 태그로 등록
* ApplicationContext에서 가져와서 사용

#### 2. Java Config 방식 (`AnnotationConfigApplicationContext`)

* Java Config 클래스에 `@Configuration`, `@Bean`으로 등록
* ApplicationContext에서 가져와서 사용

#### 3. Annotation 방식 (`@Component`, `@ComponentScan`)

* `MemberDAO` 클래스에 `@Component` 어노테이션 추가
* 설정 클래스에 `@ComponentScan` 적용
* ApplicationContext에서 자동으로 스캔하여 빈 등록

---

### 실습 흐름 예시

모든 방식 공통:

* `MemberDAO`는 간단한 DAO 역할의 클래스
* `System.out.println()`으로 객체 출력해서 등록 확인

---

### 스스로 점검하기

1. 세 가지 방식의 등록 흐름을 각각 직접 해봤는가?
2. `new` 없이 컨테이너를 통해 객체를 가져왔는가?
3. 등록된 Bean의 생성을 눈으로 확인했는가?
4. 세 방식의 차이점과 장단점을 말할 수 있는가?
