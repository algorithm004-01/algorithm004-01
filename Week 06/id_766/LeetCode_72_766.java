/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j -1] + 1;
        for (int i = 1; i <= n1; i++) dp[i][0] =dp[i - 1][0] + 1;


        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <=n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }            
                
        }
        return dp[n1][n2];
        
    }
}
// @lc code=end

