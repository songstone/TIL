package ch02_19;

public class CarFactoryTest {
    public static void main(String[] args) {
        CarFactory factory = CarFactory.getInstance();

        Car mySonata = factory.createCar();
        Car yourSonata = factory.createCar();
        Car benz = factory.createCar();

        System.out.println(mySonata.getCarNum());
        System.out.println(yourSonata.getCarNum());
        System.out.println(benz.getCarNum());
    }
}
