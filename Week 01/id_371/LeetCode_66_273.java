import java.util.Arrays;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-20 08:58
 **/

public class LeetCode_66_273 {
    public static void main(String[] args) {
//        int[] nums = {9, 9, 9}; // 1,0,0,0
        int[] nums = {8, 9, 9}; // 1,0,0,0
        int[] newArr = plusOne(nums);
        Arrays.stream(newArr).forEach(System.out::println);

    }

    public static int[] plusOne(int[] digits) {
        //从后往前遍历,遇9就设为0,非9元素+1,跳出循环,全是9长度加1
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) {
                    return incrArray(digits.length + 1);
                }
            } else {
                digits[i]++;
                break;
            }
        }
        return digits;
    }

    public static int[] incrArray(int k) {
        int[] newArray = new int[k];
        newArray[0] = 1;
        for (int i = 1; i < k; i++) {
            newArray[i] = 0;
        }
        return newArray;
    }
}
