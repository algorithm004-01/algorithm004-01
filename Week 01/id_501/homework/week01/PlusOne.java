package homework.week01;

import java.util.Arrays;

/**
 * 66. 加一
 * https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne{

    /**
     * 暴力法
     * 思路：
     * 先判断最后一位+1，是不是大于9，如果小于，直接最后一位+1，返回数组
     * 如果最后一位+1，大于9，则需要向前一位进1，从后向前遍历，
     * 如果当前数值 小于10，则直接返回
     * 如果当前数值 大于9，则当前位置为0
     * 当i = 0时，表示最后一位 +1 还是大于9，则要扩容数组
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int end = digits[digits.length - 1];
        if(end + 1 <= 9){
            digits[digits.length - 1] = end + 1;
            return digits;
        }
        for(int i =  digits.length - 1;i >= 0; i --){
            if(digits[i] + 1 <= 9){
                digits[i] = digits[i] + 1;
                break;
            }else{
                digits[i] = 0;
                if(i == 0){
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    System.arraycopy(digits, 0, result, 1, digits.length);
                    return result;
                }
            }
        }
        return digits;
    }

    /**
     * 思路：
     * 关键在于 %= 10, 与10取余，如果=0，表示+1为10，如果不为0，表示+1，小于10
     * @param digits
     * @return
     */
    public static int[] plusOne2(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i --){
            digits[i] ++ ;
            digits[i] %= 10;
            if(digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{8,9,9};
        // int[] digits = new int[]{1,2,3};
        plusOne(digits);
        System.out.println(Arrays.toString(digits));
    }

}