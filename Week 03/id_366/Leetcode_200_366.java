/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
/**
 * 方法一：深度优先遍历
 */
class Solution {      
    char[][] grid;
    int rows;
    int cols;
    
    public int numIslands(char[][] grid) { 
        this.grid = grid;
        if (grid.length == 0) return 0;
        //if (gird == null || grid.length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;
        int countNum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                countNum += sink(i, j);                 
            }
        }
        return countNum;        
    }
    
    public int sink(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return 0;
        } 
        grid[i][j] = '0';
        sink(i-1, j);
        sink(i+1, j);
        sink(i, j+1);
        sink(i, j-1);
        return 1;
    }
    
}

// @lc code=end

