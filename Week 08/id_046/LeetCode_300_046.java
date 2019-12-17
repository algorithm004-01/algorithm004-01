public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval +1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
