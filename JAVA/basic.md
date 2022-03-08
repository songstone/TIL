# JAVA basic

## 클래스, 객체, 인스턴스
- 클래스 : 객체를 만드는 설계도
- 객체 : 클래스를 기반으로 생성된 실체(**현실 세계 관점**)
- 인스턴스 : 메모리에 할당되어 실제 사용된 객체(**SW 세계 관점**)

## 접근 제어자
- private : 같은 클래스 내부에서만 접근 가능
- (default) : 같은 패키지 내부에서만 접근 가능
- protected : 같은 패키지 or 상속 관계의 클래스에서 접근 가능
- public : 클래스 외부 어디서나 접근 가능

## Array, ArrayList
- Array
    ```java
    int[] numbers;
    numbers = new int[]{1,22,34,54};
    ```
    - 사이즈가 고정
    - 기본 자료형, 객체 모두 담을 수 있다.
    - 길이 : numbers.length
    - 삭제
        ```java
        numbers = ArrayUtils.remove(numbers, index);
        ```
    - .equals() : 인스턴스 자체가 같은지 다른지 비교
- ArrayList
    ```java
    ArrayList<String> names = new ArrayList<>(Arrays.asList("song","seung","hyun"));
    ```
    - 사이즈가 동적인 배열
    - 객체만 담을 수 있다.
    - 길이 : names.size
    - 삭제
        ```java
        names.remove(index);
        ```
    - .equals() : 원소 하나하나씩 같은지 비교

## 얕은 복사, 깊은 복사
- 얕은 복사
    - 객체의 참조 값만을 복사
    - 하나의 객체를 두 변수가 참조하고 있는 형태
    - 객체 자체의 값이 변경되면 복사된 객체도 같이 변경된다.
    - System.arraycopy();
- 깊은 복사
    - 객체의 실제 값을 복사
    - 값이 변경되어도 서로 영향이 없다.
    - .clone() -> Cloneable 인터페이스 구현
    - 각 원소별로 new 인스턴스화

## String, StringBuilder, StringBuffer
- String
    - 불변 객체(Immutable Object)
    - 멀티스레드에 안전
    - 문자열 리터럴로 초기화 가능 -> Constant Pool에 저장
- StringBuilder
    - 가변 객체(Mutable Object)
    - 멀티스레드에 불안전
- StringBuffer
    - 가변 객체
    - 동가화 처리로 멀티 스레드에 안전

## Overriding, Overloading
- Overriding
    - 상속 관계에 있는 클래스 간에 같은 메서드를 재정의
- Overloading
    - 상속 관계에 있는 클래스 간에 같은 이름의 메서드를 매개변수의 유형과 개수를 다르게 확장하여 다양한 유형의 호출에 응답

## 추상클래스, 인터페이스
- 공통
    - 인스턴스화 불가능
    - 구현부가 있는 메서드(인터페이스의 경우 default, static, private method), 구현부가 없는 메서드 모두 가질 수 있음
- 차이점
    - 추상클래스(**is a kind of**)
        - 생성자 가짐
        - 다중 상속 불가
        - 여러 접근제어자
    - 인터페이스(**be able to**)
        - 생성자 x
        - 다중 상속 가능
        - 항상 public

## Static Binding, Dynamic Binding
- 정적 바인딩(static binding)
    - 컴파일 시에 데이터 타입 결정
    - static/final/private method, variable
    - instance variable
    - method overloading
- 동적 바인딩(dynamic binding)
    - 런타임 시에 데이터 타입 결정
    - instance method
    - method overriding

## Comparable, Comparator
- 둘 다 인터페이스
- Comparable
    - 메서드 : int compareTo(T o)
    - 자기자신과 매개변수를 비교
- Comparator
    - 메서드 : int compare(T o1, T o2)
    - 자기자신과 비교 불가능
    - 익명 객체 활용하자