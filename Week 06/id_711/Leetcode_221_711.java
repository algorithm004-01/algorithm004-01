package Week6;

public class Leetcode_221_711 {
    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println(maximalSquare(matrix));
    }

    /**
     * 预处理一下，a[i][j] 记录这行到j有多少个1，b[i][j]记录这列到i有多少个1
     * 当前为'1'时，
     * dp[i][j] = min(a[i][j],b[i][j]） > dp[i - 1][j - 1](不为0） ？ dp[i - 1][j - 1] + 1 : min(a[i][j], b[i][j])
     * 执行用时 :7 ms, 在所有 java 提交中击败了68.58%的用户
     * 内存消耗 :42.5 MB, 在所有 java 提交中击败了88.89%的用户
     * @param matrix
     * @return
     */
    private static int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int[][] a = new int[n + 1][m + 1];
        int[][] b = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    a[i][j] = a[i][j - 1] + 1;
                    b[i][j] = b[i - 1][j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1;
                    int x = Math.min(a[i][j],b[i][j]);
                    if (dp[i - 1][j - 1] > 0) {
                        if (x > dp[i - 1][j - 1]) {
                            dp[i][j] += dp[i - 1][j - 1];
                        }
                        else {
                            dp[i][j] = x;
                        }
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans * ans;
    }
}
