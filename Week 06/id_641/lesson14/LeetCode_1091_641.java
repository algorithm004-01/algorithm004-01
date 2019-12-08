package com.code.lesson14;


import java.util.ArrayList;
import java.util.List;

/**
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 *
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 *
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 *
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 */
public class LeetCode_1091_641 {

    //方向
    private static final int[][] direct = new int[][]{
            {-1, 0}, //左
            {1, 0},// 右
            {0, -1},//上
            {0, 1},// 下
            {1, 1},
            {-1, 1},
            {1, -1},
            {-1, -1},
    };


    //最短路径
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }

        if (grid.length == 1) {
            return grid[0][0] == 0 ? 1 : -1;
        }

        final int N = grid.length;

        if ((grid[0][0] == 1) || (grid[N - 1][N - 1] == 1)) {//如果入口和出口都不能访问
            return -1;
        }

        List<State> startSta = new ArrayList<>(N * N);
        List<State> endSta = new ArrayList<>(N * N);
        startSta.add(new State(0, 0));
        endSta.add(new State(N - 1, N - 1));

        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        visited[N - 1][N - 1] = true;

        boolean[][] startVisited = new boolean[N][N];
        boolean[][] endVisited = new boolean[N][N];
        startVisited[0][0] = true;
        endVisited[N - 1][N - 1] = true;

        int len = 1;

        while (!startSta.isEmpty() && !endSta.isEmpty()) {

            if (startSta.size() > endSta.size()) {
                List<State> tmp = startSta;
                startSta = endSta;
                endSta = tmp;
                boolean[][] tmpA = startVisited;
                startVisited = endVisited;
                endVisited = tmpA;
            }

            List<State> newStaSet = new ArrayList<>();
            for (State curSta : startSta) {
                int i = curSta.i, j = curSta.j;
                for (int[] pos : direct) {
                    int new_i = i + pos[0], new_j = j + pos[1];
                    if (new_i >= 0 && new_i < N && new_j >= 0 && new_j < N && grid[new_i][new_j] == 0) {
                        State newSta = new State(new_i, new_j);

                        if (endVisited[newSta.i][newSta.j]) {
                            return len + 1;
                        }

                        if (visited[newSta.i][newSta.j]) {
                            continue;
                        }

                        newStaSet.add(newSta);
                        visited[newSta.i][newSta.j] = true;
                        startVisited[newSta.i][newSta.j] = true;
                    }
                }
            }

            startSta = newStaSet;
            len++;
        }
        return -1;
    }

    private class State {

        int i;

        int j;

        public State(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}
