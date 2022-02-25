# 전략 패턴(strategy pattern)

- 행위(전략)를 클래스로 캡슐화해 동적으로 행위를 자유롭게 바꿀 수 있게 해주는 디자인 패턴
- 패턴 적용 전
    - 무기에 의존
    ```java
    public class GunSoldier {
        private Gun gun;

        public GunSoldier(){
            gun = new Gun();
        }

        public void performAttack(){
            System.out.println("총으로 공격합니다.");
        }
    ```
    ```java
    public class SpearSoldier {
        private Spear spear;

        public SpearSoldier(){
            spear = new Spear();
        }

        public void performAttack(){
            System.out.println("창으로 공격합니다.");
        }
    }
    ```

- 생성된 객체의 변경 사항, 추가 사항을 적용하기도 힘들고, 객체 자체의 공격 방식(전략)에 대한 설정도 어렵다.
- 전략 객체 : 전략을 구현한 객체, 전략 메서드를 가진 객체
- 컨텍스트 : 전략 객체를 사용하는 역할
- 클라이언트 : 전략 객체를 생성해 컨텍스트에 주입하는 역할
- 전략(인터페이스)
    ```java
    public interface Weapon {
        void attack();
    }
    ```
- 전략 객체
    ```java
    public class Gun implements Weapon{
        @Override
        public void attack() {
            System.out.println("적을 총으로 공격합니다.");
            }
        }
    ```
    ```java
    public class Spear implements Weapon{
        @Override
        public void attack() {
            System.out.println("적을 창으로 공격합니다.");
            }
    }
    ```
- 컨텍스트
    ```java
    public class Soldier {
        private Weapon weapon;

        public Soldier(Weapon weapon){
            this.weapon = weapon;
        }
        public void performAttack(){
            this.weapon.attack();
        }
        public void setWeapon(Weapon weapon){ 
            this.weapon = weapon;
            };
        }
    ```
- 클라이언트
    ```java
    public class Client {
        public static void main(String[] args){
            Soldier soldier = new Soldier(new Gun());
            soldier.performAttack();
            soldier.setWeapon(new Spear());
            soldier.performAttack();
        }
    }
    ```

- IoC / DI : 제어의 역전, 의존성 주입

