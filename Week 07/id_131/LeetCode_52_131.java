package com.lzhlyle.leetcode.self.no52;

public class NQueensII {
    private int size, count;

    public int totalNQueens(int n) {
        size = (1 << n) - 1;
        count = 0;
        this._locate(0, 0, 0);
        return count;
    }

    private void _locate(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }

        int poss = size & (~(row | ld | rd));
        while (poss != 0) {
            int posi = poss & (-poss);
            poss &= poss - 1;
            this._locate(row | posi, (ld | posi) << 1, (rd | posi) >> 1);
        }
    }
}
