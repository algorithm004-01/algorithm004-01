/**
 * LeetCode_52_576
 */
public class LeetCode_52_576 {
    private int size;
    private int count;

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;    
    }

    private void solve(int row, int ld, int rd) {
        if (row == size) {
            count++;
            System.out.println("count = " + count);
            return;
        }
        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos); //取到最低位的1
            pos -= p; // pos &= pos - 1，表示在pos位置放皇后
            System.out.println("row = "+ Integer.toBinaryString(row) + " "+ "pos = " + Integer.toBinaryString(pos));
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public static void main(String[] args) {
        LeetCode_52_576 lc = new LeetCode_52_576();
        System.out.println("solution:" + lc.totalNQueens(4));
        
    }

}