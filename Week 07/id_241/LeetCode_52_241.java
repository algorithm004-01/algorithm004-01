import java.util.*;
/**
 * N皇后 II
 */
class Solution {
    private int count = 0;
    private int max = 0;

    public int totalNQueens(int n) {
        max = (1 << n) - 1;
        totalNQueensHelper(0, 0, 0);
        return count;
    }

    private void totalNQueensHelper(int row, int left, int right) {
        if (row == max) {
            count++;
            return;
        }
        int pos = max & ~(row | left | right);
        while (pos != 0) {
            int p = pos & -pos;
            pos = pos - p;
            totalNQueensHelper(row | p, (left | p) << 1, (right | p) >> 1);
        }
    }
}