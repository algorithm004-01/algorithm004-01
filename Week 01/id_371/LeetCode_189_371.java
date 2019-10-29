import java.util.Arrays;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-15 11:39
 **/

public class LeetCode_189_371 {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums = {1, 2};
        int k = 3;
//        rotate(nums, k);
        rotate1(nums, k);
    }

    /**
     * 暴力法, 每次走一步
     */
    public static void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        k %= nums.length;
        while (k-- > 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums = " + nums[i]);
        }
    }

    /**
     * 三次数组反转
     */
    public static void rotate1(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k , nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);
    }

    /**
     * 将数组中的一段反转
     */
    private static int[] reverseArray(int[] nums, int start, int end) {//这里不需要 return,可以改方法签名
        while (start < end) {
            int temp = nums[end];
            nums[end--] = nums[start];
            nums[start++] = temp;
        }
        return nums;
    }

}
