package hw_210817;

import java.util.Arrays;

public class Hw4_NestedFor {
    public static void main(String[] args) {
        int[][] bankDeposit = {{300, 200, 100}, {2, 30}, {300, 50}};
        int[] bankBalance = {0, 0, 0};
        for(int i = 0; i<bankDeposit.length; i++){
            System.out.printf("%d번째 은행 입금 이력은 %s입니다.\n", i+1, Arrays.toString(bankDeposit[i]));
            for(int j=0; j<bankDeposit[i].length; j++){
                bankBalance[i] += bankDeposit[i][j];
            }
        }
        System.out.println(Arrays.toString(bankBalance));
    }
}
