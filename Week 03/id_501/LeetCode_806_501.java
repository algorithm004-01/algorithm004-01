package homework.week03;

/**
 * 860. 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change
 */
public class LeetCode_806_501{
    public static boolean lemonadeChange(int[] bills) {
        int five = 0,ten = 0;
        for(int bill : bills){
            if(bill == 5){
                five ++;
            }else if(bill == 10){
                if(five -- == 0){
                    return false;
                }
                ten ++ ;
            }else{
                if(five > 0 && ten > 0){
                    five --;
                    ten --;
                }else if(five > 2){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,10}));
    }
}