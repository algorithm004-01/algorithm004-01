package id_576;

public class LeetCode_1143_576 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    //需要注意数组越界的问题
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    /**
     * 如果是最长公共子串，dp方程将改为
     * dp[i][j] = dp[i-1][j-1] + 1(if s1[i-1] == s2[j-1])
     * else dp[i][j] = 0
     *
     * return Max(dp[i][j])
     */
}
