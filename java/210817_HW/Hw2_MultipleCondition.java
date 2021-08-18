package hw_210817;

import java.util.Scanner;

public class Hw2_MultipleCondition {
    public static void main(String[] args){
        System.out.println("회원님의 레벨을 입력해주세요(gold/silver/bronze)");
        Scanner scanner = new Scanner(System.in);
        String level = scanner.next();
        int maxLimit = 0;
        //else-if
        if(level.equals("bronze"))
            maxLimit = 50;
        else if(level.equals("silver"))
            maxLimit = 100;
        else if(level.equals("gold"))
            maxLimit = 300;
        //switch
        /*
        switch(level){
            case "bronze":
                maxLimit = 50;
                break;
            case "silver":
                maxLimit = 100;
                break;
            case "gold":
                maxLimit = 300;
                break;
        }
        */
        System.out.printf("회원님의 최대 한도는 %d만원 입니다.", maxLimit);
    }
}


