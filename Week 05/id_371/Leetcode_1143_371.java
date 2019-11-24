/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-12 10:32
 **/

public class Leetcode_1143_371 {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        int i = longestCommonSubsequence(text1, text2);
        System.out.println("i = " + i);
    }

    /**
     * 仿解1:动态规划(自顶向下)
     *
     * @author Shaobo.Qian
     * @date 2019/11/12
     * @link https://leetcode-cn.com/problems/longest-common-subsequence/solution/chao-xiang-xi-dong-tai-gui-hua-jie-fa-by-shi-wei-h/
     */
    public static int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        char[] charArr1 = text1.toCharArray();
        char[] charArr2 = text2.toCharArray();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                //保存并更新最优解(状态转移方程)
                if (charArr1[i - 1] == charArr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }

}
