package com.mrglint.leetcode.week06.solution200;

/**
 * @author luhuancheng
 * @since 2019-11-21 07:52
 */
public class Solution {

    /**
     * 声明坐标位上「上、左、下、右」四个位置的偏移量
     */
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {0, 1}};

    private static class UF {
        int count;
        int[] parent;
        // 用于路径压缩
        int[] rank;

        public UF(char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            parent = new int[rows * cols];
            rank = new int[rows * cols];

            // 将每个'1'初始化为"并查集"中的一个独立节点
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * cols + j] = i * cols + j;
                        rank[i * cols + j] = 0;
                        count++;
                    }
                }
            }
        }

        void union(int i, int j) {
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot) {
                return;
            }
            // 在合并时，利用rank来进行路径压缩。路径短的合并到路径长的
            if (rank[iRoot] > rank[jRoot]) {
                parent[jRoot] = iRoot;
            } else if (rank[iRoot] < rank[jRoot]){
                parent[iRoot] = jRoot;
            } else {
                parent[iRoot] = jRoot;
                rank[iRoot] += 1;
            }
            count--;
        }

        int find(int i) {
            while (parent[i] != i) {
                // 路径压缩
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return parent[i];
        }
    }


    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        UF uf = new UF(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 连通周围的'1'
                    for (int[] direction : DIRECTIONS) {
                        int newRow = i + direction[0];
                        int newCol = j + direction[1];
                        if (validateCoordinate(newRow, newCol, rows, cols) && grid[newRow][newCol] == '1') {
                            uf.union(newRow * cols + newCol, i * cols + j);
                        }
                    }
                }
            }
        }
        return uf.count;
    }

    private boolean validateCoordinate(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numIslands(new char[][]{{'1'}, {'1'}});
    }
}

