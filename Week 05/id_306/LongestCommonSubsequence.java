package sf.week5;

/**
 * Created by LynnSun on 2019/11/18.
 * 力扣题目地址：https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

    /**
     * 用二维数组的方式
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n1][n2];
    }

    /**
     * 用一维数组的方式，有些地方还要仔细想想
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        int len1 = text1.length(), len2 = text2.length();
        if (len1 == 0 || len2 == 0) return 0;
        char[] colText, rowText;
        if (len1 > len2) {
            colText = text2.toCharArray();
            rowText = text1.toCharArray();
        } else {
            colText = text1.toCharArray();
            rowText = text2.toCharArray();
        }
        int[] dp = new int[colText.length + 1];
        for (int i = 1; i <= rowText.length; i++) {
            int tmp = 0;
            for (int j = 1; j <= colText.length; j++) {
                int prev = tmp;
                tmp = dp[j];
                if (rowText[i - 1] == colText[j - 1]) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[colText.length];
    }
}
