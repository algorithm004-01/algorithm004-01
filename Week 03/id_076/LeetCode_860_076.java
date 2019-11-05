package week3;

/**
 * 采用贪心算法解题，没次都采用最优进行选择，没有最优办法采用次优进行处理。
 *
 * @author tangzhenhua
 * @date 2019/11/03 20:00
 */
public class LeetCode_860_076 {

    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;

        for(int i = 0; i < bills.length; i++) {
            if(bills[i] == 5) {
                five++;

            } else if(bills[i] == 10) {
                if(five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if(ten > 0 && five > 0){
                    five--;
                    ten--;
                } else if(five >= 3){
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
        LeetCode_860_076 leet = new LeetCode_860_076();
        System.out.println(leet.lemonadeChange(bills));
    }
}