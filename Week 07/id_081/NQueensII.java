/**
 * NQueensII
 */
public class NQueensII {
    private int size;
    private int count;

    private void solve(int row, int ld, int rd) {
        //当行中没有可以放置的位置
        if(row == size) {
            count++;
            return ;
        }
        //(row | ld | rd) 所有不能放置皇后的位置
        int pos = size & (~(row | ld | rd));    
        while(pos != 0) {
            int p = pos & (-pos);
            pos -= p;
            //在 p 的位置上, 放上皇后
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }
}