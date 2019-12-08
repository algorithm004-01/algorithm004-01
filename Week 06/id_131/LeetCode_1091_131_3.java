package com.lzhlyle.leetcode.recite.no1091;

import java.util.*;

public class ShortestPathInBinaryMatrix_3 {
    // two-ended bfs
    public int shortestPathBinaryMatrix(int[][] grid) {
        // base condition
        int maxX = grid.length - 1;
        int maxY = grid[0].length - 1;
        if (grid[0][0] == 1 || grid[maxX][maxY] == 1) return -1;
        if (grid.length == 1) return 1;

        Set<Cell> beginSet = new HashSet<>(Collections.singleton(new Cell(0, 0)));
        boolean[][] beginVisited = new boolean[maxX + 1][maxY + 1];
        beginVisited[0][0] = true;

        Set<Cell> endSet = new HashSet<>(Collections.singleton(new Cell(maxX, maxY)));
        boolean[][] endVisited = new boolean[maxX + 1][maxY + 1];
        endVisited[maxX][maxY] = true;

        // bfs
        return this.searchBfs(1, beginSet, endSet, grid, beginVisited, endVisited, maxX, maxY);
    }

    // bfs recursion
    private int searchBfs(int step, Set<Cell> beginSet, Set<Cell> endSet, int[][] grid,
                          boolean[][] beginVisited, boolean[][] endVisited, int maxX, int maxY) {
        // terminator
        if (beginSet.isEmpty() || endSet.isEmpty()) return -1; // cannot find

        // process
        step++;
        // always from less to more
        if (beginSet.size() > endSet.size()) {
            Set<Cell> swap = beginSet;
            beginSet = endSet;
            endSet = swap;

            endVisited = beginVisited;
        }

        Set<Cell> nextBegin = new HashSet<>();
        boolean[][] nextVisited = new boolean[maxX + 1][maxY + 1];
        for (Cell begin : beginSet) {
            // flood-fill
            grid[begin.x][begin.y] = 1;

            List<Cell> neighbors = this._getNeighbors(begin.x, begin.y, grid);
            // pruning
            for (Cell neighbor : neighbors) {
                if (endVisited[neighbor.x][neighbor.y]) return step; // meet
                if (grid[neighbor.x][neighbor.y] == 1) continue;
                grid[neighbor.x][neighbor.y] = 1; // flood-fill

                nextBegin.add(neighbor);
                nextVisited[neighbor.x][neighbor.y] = true;
            }
        }
        beginSet = nextBegin;
        beginVisited = nextVisited;

        // drill down
        return this.searchBfs(step, beginSet, endSet, grid, beginVisited, endVisited, maxX, maxY);
    }

    // directions
    private static final int[] dx = new int[]{0, 0, -1, 1, -1, -1, 1, 1};
    private static final int[] dy = new int[]{1, -1, 0, 0, 1, -1, 1, -1};

    private List<Cell> _getNeighbors(int x, int y, int[][] grid) {
        List<Cell> res = new ArrayList<>();
        for (int i = 0; i < dx.length; i++) {
            if (x + dx[i] > grid.length - 1 || x + dx[i] < 0
                    || y + dy[i] > grid[0].length - 1 || y + dy[i] < 0) continue;
            res.add(new Cell(x + dx[i], y + dy[i]));
        }
        return res;
    }

    class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 0},
                {1, 0, 0, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 0, 1},
                {0, 0, 1, 0, 0, 0, 0}
        };
        int res = new ShortestPathInBinaryMatrix_3().shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }
}
