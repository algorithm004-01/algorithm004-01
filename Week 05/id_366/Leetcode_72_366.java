/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int column = word1.length();
        int row = word2.length();
        if (row == 0 || column ==0) return Math.max(row, column);
        int[][] grid = new int[row + 1][column + 1];
        for (int j = 1; j <= column; j++ ) {
            grid[0][j] = j;
        }
        for (int i = 1; i <= row; i++) {
            grid[i][0] = i;
        }
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < column +1; j++) {
                if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    //grid[i][j] = Math.min(Math.min(grid[i - 1][j], grid[i][j - 1]), grid[i - 1][j - 1]);
                    grid[i][j] = grid[i - 1][j - 1];
                } else {
                    grid[i][j] = Math.min(Math.min(grid[i - 1][j], grid[i][j - 1]), grid[i - 1][j - 1]) + 1;
                }               
            }
        }
        return grid[row][column];
    }
}
// @lc code=end

