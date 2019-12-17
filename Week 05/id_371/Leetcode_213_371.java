/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-17 11:54
 **/

public class Leetcode_213_371 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int res = rob(nums);
        System.out.println("res = " + res);
    }

    /**
     * 原解1:dp(自底向上)
     *
     * @author Shaobo.Qian
     * @date 2019/11/17
     */
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        //1.定义需要维护的撞他提
        //1.1 需要维护的状态(1...n-1)-->子问题1:不包含最后一个元素的数组
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = nums[0];
        //1.2需要维护的状态 (2...n)-->子问题2:不包含第一个元素的数组
        int[] dp1 = new int[len];
        dp1[0] = 0;
        dp1[1] = nums[1];
        //2.对子问题求解
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }
        //3.合并结果
        return Math.max(dp[len - 1], dp1[len - 1]);
    }

}
