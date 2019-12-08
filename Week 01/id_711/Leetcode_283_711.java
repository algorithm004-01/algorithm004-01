package Week1;

import java.util.Arrays;

public class Lettcode_283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 简单模拟
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :37.6 MB, 在所有 java 提交中击败了95.46%的用户
     * @param nums
     */
    private static void moveZeros(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length ; i++) {
            nums[i] = 0;
        }
    }
}
