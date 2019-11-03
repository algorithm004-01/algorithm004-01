package Week1;

import java.util.Arrays;

public class Lettcode_66 {
    public static void main(String[] args) {
        int[] nums = {9};
        int[] ans = plusOne(nums);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * SB 的模拟做法。。。。
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :35.2 MB, 在所有 java 提交中击败了37.71%的用户
     * @param nums
     * @return
     */
    private static int[] plusOne(int[] nums) {
        nums[nums.length - 1] += 1;
        int index = nums.length - 1;
        boolean flag = false;
        while (index >= 0 && nums[index] > 9){
            if (index == 0){
                nums[index] %= 10;
                flag = true;
            }
            else{
                nums[index] %= 10;
                nums[index - 1] += 1;
            }
            index--;
        }
        if (flag){
            int[] help = new int[nums.length + 1];
            help[0] = 1;
            for (int i = 0; i < nums.length ; i++) {
                help[i + 1] = nums[i];
            }
            return help;
        }
        else return nums;
    }
}
