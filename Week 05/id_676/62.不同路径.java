import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

 /*
 *思路:动态规划dp
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)  dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] =1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1] [n -1];
    }

    //我们不需要存储整个二维数组，只要得到i - 1 和 i-2即可
    public int uniquePaths1(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1;i < m;i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
// @lc code=end

