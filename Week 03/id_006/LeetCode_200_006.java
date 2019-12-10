package com.mrglint.leetcode.week03.solution200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luhuancheng
 * @since 2019-11-03 07:50
 */
public class BfsSolution {

    /**
     * 声明坐标位上「上、左、下、右」四个位置的偏移量
     */
    private int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    /**
     * 全局变量 存储结果
     */
    private int count = 0;

    public int numIslands(char[][] grid) {
        /*
        数组为空
         */
        if (grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        /*
        标记坐标被访问的辅助数组
         */
        boolean[][] visited = new boolean[rows][cols];

        /*
         广度优先遍历
         */
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    // 以char[row][col]作为根开始进行广度优先遍历，每个根记为一个岛屿
                    count++;
                    visited[row][col] = true;
                    queue.offer(new int[]{row, col});
                    while (!queue.isEmpty()) {
                        int[] queueHead = queue.poll();
                        int queueRow = queueHead[0];
                        int queueCol = queueHead[1];
                        for (int i = 0; i < directions.length; i++) {
                            int newRow = queueRow + directions[i][0];
                            int newCol = queueCol + directions[i][1];
                            if (inArea(newRow, newCol, rows, cols) && !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                                visited[newRow][newCol] = true;
                                queue.offer(new int[]{newRow, newCol});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean inArea(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}

