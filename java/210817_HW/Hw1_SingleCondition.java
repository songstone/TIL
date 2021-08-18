package hw_210817;

public class Hw1_SingleCondition {
    public static void main(String[] args) {

        int mon = 1;
        int fri = 5;
        int sun = 7;

        System.out.println(chkWithdraw(mon));
        System.out.println(chkWithdraw(fri));
        System.out.println(chkWithdraw(sun));
    }
    private static boolean chkWithdraw(int today){
        boolean isAvailableWithdraw = false;
        if(today == 7)
            isAvailableWithdraw = true;
        return isAvailableWithdraw;
    }
}
