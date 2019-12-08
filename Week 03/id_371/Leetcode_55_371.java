/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-02 16:17
 **/

public class Leetcode_55_371 {
    public static void main(String[] args) {
//        int[] nums = {0,2,3};
        int[] nums = {1, 0, 1, 0};
//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));

    }

    /**
     * 原解1.累加有效长度
     *
     * @author Shaobo.Qian
     * @date 2019/11/2
     */
    public static boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int targetLen = nums.length;
        int maxLen = 0; //在当前位置能达到的最远位置
        for (int i = 0; i < nums.length - 1; i++) {
            maxLen = Math.max(maxLen - 1, nums[i]);
            //maxLen和 nus[i]都为0,已经跳不过去了
            if (maxLen == 0 && nums[i] == 0) return false;
            targetLen = targetLen - 1;
            if (maxLen >= targetLen) return true;
        }
        return false;
    }

}
