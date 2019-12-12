public class LeetCode_64_276 {
    public int minPathSum(int[][] grid) {
        //重复性 dp[i][j] = min(dp[i-1][j], dp[i][j-1])
        int R = grid.length, C = grid[0].length;
        for (int i = 0; i < R; ++ i) {
            for (int j = 0; j < C; ++ j) {
                if (i < 1 ) grid[i][j] += j < 1 ? 0 : grid[i][j-1];
                else if (j < 1 ) grid[i][j] += grid[i-1][j];
                else grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[R-1][C-1];
    }
    /*public int minPathSum(int[][] grid) {
        //重复性 dp[i][j] = min(dp[i-1][j], dp[i][j-1])
        int R = grid.length, C = grid[0].length;
        for (int i = 0; i < R; ++ i) {
            for (int j = 0; j < C; ++ j) {
                 grid[i][j] = Math.min(i < 1 ? 0 :grid[i-1][j], j < 1 ? 0 : grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[R-1][C-1];*/
    }
}
