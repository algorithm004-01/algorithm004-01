package sf.week5;

/**
 * Created by LynnSun on 2019/11/19.
 * 力扣题目地址：https://leetcode-cn.com/problems/edit-distance/
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int wLen1 = word1.length();
        int wLen2 = word2.length();
        int[][] dp = new int[wLen1 + 1][wLen2 + 1];
        // 第一行
        for (int j = 1; j <= wLen2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= wLen1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= wLen1; i++) {
            for (int j = 1; j <= wLen2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[wLen1][wLen2];
    }
}
