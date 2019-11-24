// https://leetcode-cn.com/problems/minimum-path-sum/
// 64. 最小路径和

public class LeetCode_64_716 {

    // dp
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) dp[j] = dp[j - 1] + grid[i][j];
                else if (i > 0 && j == 0) dp[j] = dp[j] + grid[i][j];
                else if (i > 0 && j > 0) dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}