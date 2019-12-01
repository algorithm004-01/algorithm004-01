package com.lzhlyle.leetcode.self.no51;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens_3 {
    public List<List<String>> solveNQueens(int n) {
        // base condition
        if (n <= 0) return Collections.emptyList();
        if (n == 1) return Collections.singletonList(Collections.singletonList("Q"));

        // initial
        List<List<String>> result = new ArrayList<>();
        int[] queensCol = new int[n];
        int[] visitedCol = new int[n];
        int[] visitedUphill = new int[2 * n - 1]; // x + y
        int[] visitedDownhill = new int[2 * n - 1]; // n - 1 + x - y

        // dfs
        this.locate(0, n, result, queensCol, visitedCol, visitedUphill, visitedDownhill);

        return result;
    }

    private void locate(int row, int n, List<List<String>> result, int[] queensCol,
                        int[] visitedCol, int[] visitedUphill, int[] visitedDownhill) {
        // terminator
        // each col
        for (int col = 0; col < n; col++) {
            // current position: (row, col)
            if (this.validate(row, col, n, visitedCol, visitedUphill, visitedDownhill)) {
                // process
                queensCol[row] = col;
                visitedCol[col] = 1;
                visitedUphill[row + col] = 1;
                visitedDownhill[n - 1 + row - col] = 1;

                if (row == n - 1) this.appendBoard(n, queensCol, result);
                    // drill down
                else this.locate(row + 1, n, result, queensCol, visitedCol, visitedUphill, visitedDownhill);

                // reverse state
                queensCol[row] = 0;
                visitedCol[col] = 0;
                visitedUphill[row + col] = 0;
                visitedDownhill[n - 1 + row - col] = 0;
            }
        }
    }

    private boolean validate(int x, int y, int n,
                             int[] visitedCol, int[] visitedUphill, int[] visitedDownhill) {
        return visitedCol[y] + visitedUphill[x + y] + visitedDownhill[n - 1 + x - y] == 0;
    }

    private void appendBoard(int n, int[] queensCol, List<List<String>> result) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder builder = new StringBuilder();
            for (int col = 0; col < n; col++) {
                if (queensCol[row] == col) builder.append('Q');
                else builder.append('.');
            }
            board.add(builder.toString());
        }
        result.add(board);
    }
}
