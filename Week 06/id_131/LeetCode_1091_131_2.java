package com.lzhlyle.leetcode.recite.no1091;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathInBinaryMatrix_2 {
    // bfs A* search BUT DO NOT WORK BETTER..so sad
    public int shortestPathBinaryMatrix(int[][] grid) {
        // base condition
        int maxX = grid.length - 1;
        int maxY = grid[0].length - 1;
        if (grid[0][0] == 1 || grid[maxX][maxY] == 1) return -1;
        if (grid.length == 1) return 1;

        int level = 1;

        // bfs
        PriorityQueue<Cell> nextSteps = new PriorityQueue<>(Comparator.comparingInt(c -> (maxX - c.x + maxY - c.y)));
        nextSteps.add(new Cell(0, 0));
        grid[0][0] = 1; // visited
        // terminator
        while (!nextSteps.isEmpty()) {
            level++;
            List<Cell> positions = new ArrayList<>();
            while (!nextSteps.isEmpty()) positions.add(nextSteps.remove()); // remove all
            for (Cell position : positions) {
                // process
                // drill down
                List<Cell> children = this._getNeighbors(position.x, position.y, grid);
                // pruning
                for (Cell child : children) {
                    if (child.x == grid.length - 1 && child.y == grid[0].length - 1) return level;

                    if (grid[child.x][child.y] == 1) continue;

                    grid[child.x][child.y] = 1; // visited
                    nextSteps.add(new Cell(child.x, child.y));
                }
            }

            // reverse state
        }

        return -1;
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
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0}
        };
        int res = new ShortestPathInBinaryMatrix_2().shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }
}
