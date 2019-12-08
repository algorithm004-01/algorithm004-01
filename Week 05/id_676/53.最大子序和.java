/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

/*
*思路：动态规划
*1.分治（分解成子问题)：max_sum(i) = Max（max_sum(i-1)+nums[i],nums[i])
*2.状态数组：f[i]
*3.DP方程：f[i] = Max(f[i - 1],0) + nums[i];
*/

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
            //dp[i] = nums[i] + dp[i - 1] > 0 ? dp[i - 1] : 0;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
// @lc code=end
class SolutionOne {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(0, nums[i - 1]) + nums[i];
            //nums[i] = nums[i-1] > 0?nums[i-1] + nums[i] : nums[i];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
