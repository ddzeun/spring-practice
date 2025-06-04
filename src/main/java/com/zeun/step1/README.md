
### 1단계 목표:  IoC 컨테이너 기본 이해

**IoC 컨테이너로 객체를 생성하고 사용하는 흐름을 직접 경험하기**

---

### 실습 과제

#### 아래의 두 가지 방법 중 하나를 선택해서 실습해보기 (혹은 둘 다!)

#### XML 방식 (`GenericXmlApplicationContext`)

1. `MemberDTO`라는 클래스를 만들고 필드와 toString() 메서드 정의
2. XML에 bean 등록
3. `ApplicationContext`에서 가져와서 출력해보기

#### Java Config 방식 (`AnnotationConfigApplicationContext`)

1. `MemberDTO` 클래스를 Java Config로 등록 (@Bean)
2. `ApplicationContext`에서 가져와서 출력해보기

---

### 실습 예시 설명

* `MemberDTO`는 이름(name), 나이(age) 필드가 있는 간단한 객체
* XML이나 Java Config로 등록
* 메인 클래스에서 `ApplicationContext`로 등록된 빈을 가져오고 출력

---

스스로 점검하기

1. IoC 컨테이너를 내가 직접 초기화했다
2. 객체를 직접 new 하지 않고 컨테이너에서 가져왔다
3. 등록한 bean을 꺼내 출력해봤다
