package com.ann.leetCode.medium;

public class LeetCode_64_MinPathSum {

    /**
     * 自顶向下 + 记忆数组 MEMO
     * 时间复杂度：O(M*N)
     * 空间复杂度：O(M*N)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        visitGrid(grid, 0, 0, visited, 0);
        return visited[grid.length - 1][grid[0].length - 1];
    }

    public void visitGrid(int[][] grid, int currentX, int currentY, int[][] visited, int preSum) {
        if (currentX >= grid.length || currentY >= grid[0].length)
            return;
        if (visited[currentX][currentY] == 0 || preSum + grid[currentX][currentY] < visited[currentX][currentY]) {
            visited[currentX][currentY] = preSum + grid[currentX][currentY];
            visitGrid(grid, currentX + 1, currentY, visited, visited[currentX][currentY]);
            visitGrid(grid, currentX, currentY + 1, visited, visited[currentX][currentY]);
        }
    }

    public int visitGrid1(int[][] grid, int currentX, int currentY, int[][] visited) {
        if (currentX >= grid.length || currentY >= grid[0].length)
            return Integer.MAX_VALUE;
        if ((currentX == grid.length -1 && currentY == grid[0].length - 1))
            return grid[currentX][currentY];
        if (visited[currentX][currentY] == 0) {
            visited[currentX][currentY] = grid[currentX][currentY] +
                    Math.min(visitGrid1(grid, currentX + 1, currentY, visited),
                            visitGrid1(grid, currentX, currentY + 1, visited));
        }
        return visited[currentX][currentY];
    }

    /**
     * #3
     * bottom-up 时间复杂度为O(M*N)
     * 空间复杂度： O（1）
     * M:行数  N:列数
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        int maxX = grid.length - 1, maxY = grid[0].length - 1;
        for (int i = maxX - 1; i >=0; --i) {
            grid[i][maxY] += grid[i + 1][maxY];
        }
        for (int j = maxY - 1; j >= 0; --j) {
            grid[maxX][j] += grid[maxX][j + 1];
        }
        for (int i = maxX - 1; i >= 0; --i) {
            for (int j = maxY - 1; j >= 0; --j) {
                if (grid[i + 1][j] <= grid[i][j + 1]) {
                    grid[i][j] += grid[i + 1][j];
                } else {
                    grid[i][j] += grid[i][j + 1];
                }
            }
        }
        return grid[0][0];
    }

    /**
     * #4 IMPROVEMENT OF #3
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        int maxX = grid.length - 1, maxY = grid[0].length - 1;
        for (int i = maxX; i >= 0; --i) {
            for (int j = maxY; j >= 0; --j) {
                if (i == maxX && j == maxY) {
                    continue;
                } else if (i == maxX) {
                    grid[i][j] += grid[i][j + 1];
                } else if (j == maxY) {
                    grid[i][j] += grid[i + 1][j];
                } else if (grid[i + 1][j] <= grid[i][j + 1]) {
                    grid[i][j] += grid[i + 1][j];
                } else {
                    grid[i][j] += grid[i][j + 1];
                }
            }
        }
        return grid[0][0];
    }

    /**
     * 动态规划 使用一维数组
     * @param grid
     * @return
     */
    public int minPathSum3(int[][] grid) {

        return grid[0][0];
    }

    /**
     * 从坐上角开始
     * 动态规划 使用一维数组
     * @param grid
     * @return
     */
    public int minPathSum4(int[][] grid) {

        return grid[0][0];
    }
}
