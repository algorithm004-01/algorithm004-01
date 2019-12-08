//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
//
//
// 示例 2:
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集
package com.aseara.leetcode.editor.cn.a200;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 200.岛屿数量 <br />
 * Date: 2019/11/3 <br/>
 *
 * @author qiujingde
 */
class NumberOfIslands {
    private Solution solution = new Solution();

    @Test
    void test1() {
        char[][] island = new char[][] {
                new char[] {'1','1','1','1','0'},
                new char[] {'1','1','0','1','0'},
                new char[] {'1','1','0','0','0'},
                new char[] {'0','0','0','0','0'}
        };
        assertEquals(1, solution.numIslands(island));

        island = new char[][] {
                new char[] {'1','1','0','0','0'},
                new char[] {'1','1','0','0','0'},
                new char[] {'0','0','1','0','0'},
                new char[] {'0','0','0','1','1'}
        };
        assertEquals(3, solution.numIslands(island));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numIslands(char[][] grid) {
        return solve2(grid);
    }

    private int solve1(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    cnt ++;
                    destroyIsland(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private void destroyIsland(char[][] grid, int x, int y) {
        grid[x][y] = '0';

        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
            destroyIsland(grid, x - 1, y);
        }

        if (x + 1 < grid.length && grid[x + 1][y] == '1') {
            destroyIsland(grid, x + 1, y);
        }

        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
            destroyIsland(grid, x, y - 1);
        }

        if (y + 1 < grid[x].length && grid[x][y + 1] == '1') {
            destroyIsland(grid, x, y + 1);
        }
    }

    private int solve2(char[][] grid) {
        if (grid == null || grid.length == 0
                || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        UnionFind unionFind = new UnionFind(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    unionFind.count --;
                } else {
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        unionFind.union(i, j, i + 1, j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        unionFind.union(i, j, i, j + 1);
                    }
                }
            }
        }

        return unionFind.count;
    }

    static class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        int m;
        int n;

        UnionFind(int m, int n) {
            this.m = m;
            this.n = n;
            count = m * n;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    parent[i * n + j] = i * n + j;
                }
            }
        }

        int get(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        int get(int i, int j) {
            return get(i * n + j);
        }

        void union(int p1, int p2) {
            p1 = get(p1);
            p2 = get(p2);
            if (p1 != p2) {
                if (rank[p2] > rank[p1]) {
                    parent[p1] = p2;
                } else {
                    parent[p2] = p1;
                    rank[p1] += rank[p1] == rank[p2] ? 1 : 0;
                }
                count --;
            }
        }

        void union(int i1, int j1, int i2, int j2) {
            union(i1 * n + j1, i2 * n + j2);
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
