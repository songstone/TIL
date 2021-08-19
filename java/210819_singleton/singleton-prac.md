## 싱글톤 패턴
- 프로그램에서 인스턴스가 단 한개만 생성되어야 할 때 사용
- 생성자는 private으로 선언
- 클래스 내부에서 private static으로 instance 생성
- 클래스 외부에 instance를 제공하기 위한 getInstance 메서드 정의
- 단, 인스턴스 생성이 private이므로 외부에서 instance를 제공 받을 수 있도록 public static을 메서드 정의
- 예제코드
    - [Car](./Car.java)
    - [CarFactory](./CarFactory.java)
    - [CarFactoryTest](./CarFactory.java)