package medium;

/**
 * @author 潘磊明
 * @date 2019/11/15
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j ==0) dp[0] = grid[0][0];
                else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[0] = dp[0] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
                }
            }
        }
        return dp[col - 1];
    }
}
