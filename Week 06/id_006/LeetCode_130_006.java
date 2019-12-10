package com.mrglint.leetcode.week06.solution130;

/**
 * @author luhuancheng
 * @since 2019-11-21 09:01
 */
public class Solution {

    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static class UF {
        int count;
        int[] parent;
        // 用于路径压缩
        int[] rank;

        public UF(char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            parent = new int[rows * cols + 1];
            rank = new int[rows * cols + 1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
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

        boolean connected(int i, int j) {
            return find(i) == find(j);
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;
        UF uf = new UF(board);
        // 将rows * cols 视为边界为'O'的一个集合
        // 遍历矩阵，连接所有'O'，将边界的'O'与rows * cols连接
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    // 如果处于边界，则与rows * cols连接
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        uf.union(node(i, j, cols), rows * cols);
                    } else {
                        // 连接上下左右节点为'O'的节点
                        for (int[] direction : DIRECTIONS) {
                            if (board[i + direction[0]][j + direction[1]] == 'O') {
                                uf.union(node(i, j, cols), node(i + direction[0], j + direction[1], cols));
                            }
                        }
                    }
                }
            }
        }

        // 替换所有不与边界'O'相连的'O'为'X'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!uf.connected(node(i, j, cols), rows * cols)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int node(int row, int col, int cols) {
        return row * cols + col;
    }
}

