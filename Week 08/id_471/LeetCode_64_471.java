class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[] = new int[n];

        for (int i = 0; i < grid[0].length; i++) {
            dp[i] = i == 0 ? grid[0][i] : dp[i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}