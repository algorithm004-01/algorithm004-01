package easy;

/**
 * @author 潘磊明
 * @date 2019/11/12
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        //状态变量 1为偷 0为不偷
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        //dp方程
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][1], dp[nums.length - 1][0]);
    }
}
