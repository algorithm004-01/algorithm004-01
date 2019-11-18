/**
 * Leetcode_62_576  uniquePaths
 */
public class Leetcode_62_576 {
    //1.dp1,n-->row,m-->col
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }

    public int uniquePaths2(int m, int n) {
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i==0 || j==0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[n-1][m-1];
    }
}