// https://leetcode-cn.com/problems/maximal-square/
// 221. 最大正方形

public class LeetCode_221_716 {
    // dp
    public int maximalSquare1(char[][] matrix) {
        int row = matrix.length, col = row > 0 ? matrix[0].length : 0;
        int[][] dp = new int[row + 1][col + 1];
        int maxlen = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    maxlen = Math.max(maxlen, dp[i][j]);
                }
            }
        }
        return maxlen * maxlen;
    }

    // 优化空间 dp
    public int maximalSquare2(char[][] matrix) { 
        int row = matrix.length, col = row > 0 ? matrix[0].length : 0;
        int[] dp = new int[col + 1];
        int maxlen = 0;
        int leftUp = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(dp[j], Math.min(dp[j - 1], leftUp)) + 1;
                    maxlen = Math.max(maxlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                leftUp = temp;
            }
        }
        return maxlen * maxlen;
    }

    // 应该还可以使用 bfs
}