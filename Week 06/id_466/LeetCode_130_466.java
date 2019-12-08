//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//
// 示例:
//
// X X X X
//X O O X
//X X O X
//X O X X
//
//
// 运行你的函数后，矩阵变为：
//
// X X X X
//X X X X
//X X X X
//X O X X
//
//
// 解释:
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// Related Topics 深度优先搜索 广度优先搜索 并查集
package com.aseara.leetcode.editor.cn.a130;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * desc: 130.被围绕的区域 <br />
 * Date: 2019/11/20 <br/>
 *
 * @author qiujingde
 */
class SurroundedRegions {
    private Solution solution = new Solution();

    @Test
    void test1() {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};

        char[][] expected = {
                {'X','X','X','X'},
                {'X','X','X','X'},
                {'X','X','X','X'},
                {'X','O','X','X'}};
        solution.solve(board);
        assertArrayEquals(expected, board);


        char[][] board2 = {
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}};

        char[][] expected2 = {
                {'O','X','X','O','X'},
                {'X','X','X','X','O'},
                {'X','X','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}};

        solution.solve(board2);
        assertArrayEquals(expected2, board2);

        char[][] board3 = {
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}};

        char[][] expected3 = {
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}};

        solution.solve(board3);
        assertArrayEquals(expected3, board3);


        char[][] board4 = {
                {'O','X','O','O','O','X'},
                {'O','O','X','X','X','O'},
                {'X','X','X','X','X','O'},
                {'O','O','O','O','X','X'},
                {'X','X','O','O','X','O'},
                {'O','O','X','X','X','X'}};

        char[][] expected4 = {
                {'O','X','O','O','O','X'},
                {'O','O','X','X','X','O'},
                {'X','X','X','X','X','O'},
                {'O','O','O','O','X','X'},
                {'X','X','O','O','X','O'},
                {'O','O','X','X','X','X'}};

        solution.solve(board4);
        assertArrayEquals(expected4, board4);

        char[][] board5 = {
                {'X','O','X','X'},
                {'O','X','O','X'},
                {'X','O','X','O'},
                {'O','X','O','X'},
                {'X','O','X','O'},
                {'O','X','O','X'}};
        solution.solve(board5);
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        solve2(board);
    }

    // 沉岛法
    private void solve1(char[][] board) {
        if (board == null || board.length < 3
                || board[0] == null || board[0].length < 3) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            tag(board, i, 0);
            tag(board, i, n - 1);
        }
        for (int i = 1; i < n - 1; i++) {
            tag(board, 0, i);
            tag(board, m - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '@') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void tag(char[][] board, int i, int j) {
        if (board[i][j] == 'X' || board[i][j] == '@') {
            return;
        }
        board[i][j] = '@';
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int i2 = i + di[k];
            int j2 = j + dj[k];
            if (i2 >= 0 && i2 < board.length
                    && j2 >= 0 && j2 < board[0].length) {
                tag(board, i2, j2);
            }
        }
    }

    // 并查集
    private void solve2(char[][] board) {
        if (board == null || board.length < 3
                || board[0] == null || board[0].length < 3) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        UnionFind unionFind = new UnionFind(m, n);

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == 'O' && board[i + 1][j] == 'O') {
                    unionFind.join(i, j, i + 1, j);
                }
                if (board[i][j] == 'O' && board[i][j + 1] == 'O') {
                    unionFind.join(i, j, i, j + 1);
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && unionFind.island(i, j)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    static class UnionFind {
        int m;
        int n;
        int[] parent;
        int[] rank;
        boolean[] land;

        UnionFind(int m, int n) {
            this.m = m;
            this.n = n;
            parent = new int[m * n];
            rank = new int[m * n];
            land = new boolean[m * n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    parent[i * n + j] = i * n + j;
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        land[i * n + j] = true;
                    }
                }
            }
        }

        int get(int p) {
            if (parent[p] != p) {
                parent[p] = get(parent[p]);
            }
            return parent[p];
        }

        int get(int i, int j) {
            return get(i * n + j);
        }

        boolean island(int i, int j) {
            return !land[get(i, j)];
        }

        void join(int i1, int j1, int i2, int j2) {
            int p1 = get(i1, j1);
            int p2 = get(i2, j2);

            if (p1 != p2) {
                if (rank[p1] < rank[p2]) {
                    parent[p1] = p2;
                    land[p2] = land[p1] || land[p2];
                } else {
                    parent[p2] = p1;
                    land[p1] = land[p1] || land[p2];
                    rank[p1] += rank[p1] == rank[p2] ? 1 : 0;
                }
            }
        }

    }



}
//leetcode submit region end(Prohibit modification and deletion)
