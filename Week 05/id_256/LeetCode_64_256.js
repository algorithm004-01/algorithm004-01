/*
 * @lc app=leetcode.cn id=64 lang=javascript
 *
 * [64] 最小路径和
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    //DP
    let m = grid.length;
    if (m == 0) return 0;
    let n = grid[0].length;
    if (n == 0) return 0;
    for (let i = m - 1; i >= 0; i--) {
      for (let j = n - 1; j >= 0; j--) {
        if (i == m - 1 && j == n - 1) continue;
        if (i == m - 1) {
          grid[i][j] = grid[i][j] + grid[i][j + 1];
          continue;
        }
        if (j == n - 1) {
          grid[i][j] = grid[i][j] + grid[i + 1][j];
          continue;
        }
        grid[i][j] = Math.min(
          grid[i][j] + grid[i + 1][j],
          grid[i][j] + grid[i][j + 1]
        );
      }
    }
    return grid[0][0];
  };
  // @lc code=end
  