# DIP(의존 역전 원칙)
- 고차원의 모듈이 저차원 모듈에 의존해서는 안된다.
- 자주 변경되는 구체적인 것(ex.구체적인 클래스)에 의존하지 말자
- 구체화된 것을 추상적인 것(ex.인터페이스)에 의존하게 하자

- 개방 폐쇄 원칙 : 변화되는 부분을 추상화하고 다형성을 이용하여 기능확장을 하면서도 기존의 코드를 수정 하지 않도록 설계
- 의존 역전 원칙 : 개방 폐쇄 원칙에서 변화되는 부분의 추상화 지원 원칙
- 리스코프 치환 원칙 : 개방 폐쇄 원칙에서 다형성 지원 원칙

- 원칙 적용 전
    ```java
    public class Car{
        private HankookTire hankookTire;

        public void setTire(HankookTire hankookTire){
            this.hankookTire = hankookTire;
        }

        public void run(){
            this.hankookTire.roll();
        }
    ```
    ```java
    public class Car{
        private KumhoTire kumhoTire;

        public void setTire(KumhoTire kumhoTire){
            this.kumhoTire = kumhoTire;
        }

        public void run(){
            this.kumhoTIre.roll();
        }
    }
    ```

- 원칙 적용 후
    ```java
    public interface Tire{
        public void roll();
    }
    ```
    ```java
    public class KumhoTire implements Tire{
        public void roll(){
            System.out.println("금호타이어 달린다.")
        }
    }
    ```
    ```java
    public class HankookTire implements Tire{
        public void roll(){
            System.out.println("한국타이어 달린다.")
        }
    }
    ```
    ```java
    public class Car{
        private Tire tire;

        public void setTire(Tire tire){
            this.tire = tire;
        }

        public void run(){
            this.tire.roll();
        }
    }
    ```


