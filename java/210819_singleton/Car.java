package ch02_19;

public class Car {
    private static int serialNum = 10001;
    private int CarNum;

    Car() {
        CarNum = serialNum;
        serialNum++;
    }

    public static int getSerialNum() {
        return serialNum;
    }

    public int getCarNum() {
        return CarNum;
    }

    public void setCarNum(int carNum) {
        CarNum = carNum;
    }
}
