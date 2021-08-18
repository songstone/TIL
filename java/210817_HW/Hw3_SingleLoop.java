package hw_210817;

import java.util.Scanner;

public class Hw3_SingleLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = 1;
        int maxCount = 10;
        // while 문
        while (maxCount > 0) {
            amount = scanner.nextInt();
            if (amount == 0)
                break;
            else
                --maxCount;
            System.out.println("남은 송금 횟수는 " + maxCount + "번 입니다.");
        }

        // for 문
        /*for (; maxCount>0;){
            amount = scanner.nextInt();
            if(amount == 0)
                break;
            else
                --maxCount;
            System.out.println("남은 송긍 횟수는 " + maxCount + "번 입니다.");
        }*/

        // do-while 문
        /*do{
            amount = scanner.nextInt();
            if(amount == 0)
                break;
            else
                --maxCount;
            System.out.println("남은 송금 횟수는 " + maxCount + "번 입니다.");
        } while(maxCount > 0);*/
    }
}
