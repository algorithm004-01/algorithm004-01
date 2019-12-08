package com.lzhlyle.leetcode.self.no51;

import java.util.ArrayList;
import java.util.List;

public class NQueens_4 {
    private List<List<String>> res;
    private int size;

    public List<List<String>> solveNQueens(int n) {
        size = (1 << n) - 1;
        res = new ArrayList<>();
        this._locate(0, 0, 0, 0, new int[n]);
        return res;
    }

    private void _locate(int level, int row, int ld, int rd, int[] solution) {
        if (row == size) {
            res.add(this.generateSolution(solution));
            return;
        }

        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            pos &= pos - 1;
            solution[level] = p;
            this._locate(level + 1, row | p, (ld | p) << 1, (rd | p) >> 1, solution);
        }
    }

    private List<String> generateSolution(int[] solution) {
        List<String> playout = new ArrayList<>();
        for (int row : solution) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < solution.length; i++) {
                builder.append((row >> i & 1) == 1 ? 'Q' : '.');
            }
            playout.add(builder.toString());
        }
        return playout;
    }

    public static void main(String[] args) {
        new NQueens_4().solveNQueens(4);
    }
}
