/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-30 15:36
 **/

public class Leetcode_221_371 {

    /**
     * 仿解1:dp:自顶向下(循环+记忆化)
     *
     * @author Shaobo.Qian
     * @date 2019/12/1
     * @link https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode/
     */
    public int maximalSquare(char[][] matrix) {
        //矩阵中当前1位置,最大正方形的边长
        //dp(i,j)=min(dp(i-1,j),dp(i,j-1),dp(i-1,j-1))+1

        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];//对 dp 的主动赋值是从 dp[1][1]开始的,方便根据 dp 方程计算 (dp[1][1]对应 matrix[0][0]),dp[1][1]开始,一直到 dp[rows][cols],所以 dp 的空间是 new int[rows + 1][cols + 1];
        int maxsqlen = 0;//最大正方形边长
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') { // matrix[i-1][j-1] :矩阵当前的单元格
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }

    /**
     * 防解2:dp 空间优化(循环+记忆化)
     *
     * @author Shaobo.Qian
     * @date 2019/12/1
     * @link https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode/
     */
    public int maximalSquare1(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0;
        int prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];//上一个dp[j]
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;//等式左边 dp[j]为当前层的 dp[j],等式右边为上一层的 dp[j]
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
}
