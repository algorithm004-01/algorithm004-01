public class LeetCode_198_HouseRobber {
    public static void main(String[] args) {
        Solution solution = new LeetCode_198_HouseRobber().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {

            if (nums == null || nums.length == 0) return 0;
            // 分解子问题
            // 第 i 个房子能偷到的最大金额
            //  1、偷这个房子，则不能偷第 i-1 个房子，最大金额为：第 i-2 个房子的最大金额 + 当前房子的金额
            //  2、不偷这个房子，则必偷第 i-1 个房子（因为都是正数），最大金额为：第 i-1 个房子的最大金额（包含了偷和不偷的情况）
            // 定义状态数组
            // dp[i] 代表第 i 个房子能偷到的最大金额
            // DP方程
            // dp(i) = max(dp(i - 2) + nums[i], dp(i - 1))
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[nums.length - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}