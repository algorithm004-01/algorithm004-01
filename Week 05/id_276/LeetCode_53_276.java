public class LeetCode_53_276 {
/*    //重复性：f(i) = math(f(i-1), 0) + a[i]
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; ++i)
            dp[i] = Math.max(dp[i-1], 0) + nums[i];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i< dp.length; ++i) if (dp[i] > max) max = dp[i];
        return max;
    }*/
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            nums[i] = Math.max(nums[i-1], 0) + nums[i];
            if (nums[i] > max) max = nums[i];
        }
        return max;
    }

}
