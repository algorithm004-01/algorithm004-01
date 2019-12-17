/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] res = grid;
        int i = 0;
        int j = 0;
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j ++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0 && j > 0) {
                    res[i][j] = res[i][j - 1] + grid[i][j];
                } else if (i > 0 && j == 0) {
                    res[i][j] = res[i - 1][j] + grid[i][j];
                } else {
                    res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
                }
            }
        }
        return res[i - 1][j - 1];
    }
}
// @lc code=end

