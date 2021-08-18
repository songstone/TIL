package hw_210817;

import java.util.Scanner;

public class Hw5_Continue_for {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = 1;
        int maxCount = 10;
        for (;maxCount>0;){
            System.out.println("입금할 금액을 입력 해주세요.");
            amount = scanner.nextInt();
            if(amount == 0) {
                System.out.println("금액을 다시 입력 해주세요.");
                continue;
            }
            else
                --maxCount;
            System.out.println("남은 송긍 횟수는 " + maxCount + "번 입니다.");
        }
    }
}
