/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-28 16:37
 * @link: https://www.jianshu.com/p/d16707207de8
 **/

public class Leetcode_52_371 {
    public static void main(String[] args) {
        int count = totalNQueens(8);
        System.out.println("count = " + count);
    }

    //    private static final int N = 8;// 皇后数量，可拓展为N皇后
    private static int count = 0; //总方法数
    private static int limit;//需要考虑的位数的2进制最大值(n=8,limit = 255(1111 1111)) 说明下一行所有位置都被占用了

    public static int totalNQueens(int n) {
        limit = (1 << n) - 1;
        backtrace(n, 0, 0, 0, 0);
        return count;
    }

    private static void backtrace(int n, int col, int pi, int na, int row) {
        if (row == n) { //每一行都放置了皇后,成功数+1
            count++;
            return;
        }

        int used = col | pi | na;
        while (used < limit) {
            //获取最右边可以放置皇后的位置
            int using = (used + 1) & (~used);//used +1 (会把最右边的0变为1) & (~used 也会将最右边的0变为1) ===>最右边的0变为1,其它位都变为0,<==== used &(~used) 可以将所有位变为0
            //主对角线(pi)上在下一行占用的位置:limit & ((pi | using) >> 1)
            //副对角线(na)上在下一行占用的位置:limit & ((na | using) << 1
            backtrace(n, col | using, limit & ((pi | using) >> 1), limit & ((na | using) << 1), row + 1);
            used |= using; //把当前行,刚才已经占用的位置设置为不能放置
        }
    }

}

