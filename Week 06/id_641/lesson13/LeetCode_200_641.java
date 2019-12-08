package com.code.lesson13;


/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 */
public class LeetCode_200_641 {


    class UnionFind {

        int count;

        int[] parent;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                parent[rootx] = rooty;
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    //并查集
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int total = 0, row = grid.length, col = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    int old = i * col + j;
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(old, (i - 1) * col + j);
                    }
                    if (i + 1 < row && grid[i + 1][j] == '1') {
                        uf.union(old, (i + 1) * col + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(old, i * col + j - 1);
                    }
                    if (j + 1 < col && grid[i][j + 1] == '1') {
                        uf.union(old, i * col + j + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }
}
