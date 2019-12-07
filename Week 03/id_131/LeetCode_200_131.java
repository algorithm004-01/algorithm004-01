package com.lzhlyle.leetcode.self.no200;

public class NumberOfIslands_Short {
    public int numIslands(char[][] grid) {
        // base condition
        if (grid.length <= 0 || grid[0].length <= 0) return 0;

        int count = 0;

        // traversal
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    // dfs
                    count += this._sinkDown(grid, row, col);
                }
            }
        }

        return count;
    }

    private int _sinkDown(char[][] grid, int row, int col) {
        // terminator
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') return 0;

        // process
        grid[row][col] = '0';

        // drill down
        this._sinkDown(grid, row, col + 1); // east
        this._sinkDown(grid, row, col - 1); // west
        this._sinkDown(grid, row + 1, col); // south
        this._sinkDown(grid, row - 1, col); // north

        // reverse state

        return 1;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '1', '0'}
        };
        int res = new NumberOfIslands_Short().numIslands(grid);
        System.out.println(res);
    }
}
