package com.lzhlyle.leetcode.self.no64;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int width = grid.length;
        int height = grid[0].length;

        // 预处理: 最下一行, 最右一列
        for (int column = height - 2; column >= 0; column--) { // 从倒数第二格开始
            grid[width - 1][column] += grid[width - 1][column + 1];
        }

        // 预处理: 最右一列
        for (int row = width - 2; row >= 0; row--) { // 从倒数第二行开始
            grid[row][height - 1] += grid[row + 1][height - 1];
        }

        for (int row = width - 2; row >= 0; row--) { // 从倒数第二行开始
            for (int column = height - 2; column >= 0; column--) { // 从倒数第二格开始
                grid[row][column] += Math.min(grid[row + 1][column], grid[row][column + 1]);
            }
        }
        return grid[0][0];
    }
}
