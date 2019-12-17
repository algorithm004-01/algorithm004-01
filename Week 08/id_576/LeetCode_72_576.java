package id_576;

public class LeetCode_72_576 {

    // Approach1: BFS, twe-ended BFS
    public int minDistance1(String word1, String word2) {

        return 0;
    }

    // Approach2: DP
    /**
     * dp[i] 如何定义？
     * dp[i][j]  // word1.substr(0,i) 与
     * word2.substr(0,j) 之间的编辑距离
     * 感觉跟uniquepath那道题差不多
     */

    public int minDistance2(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // first row
        for (int j = 1; j <= n2 ; j++) dp[0][j] = dp[0][j - 1] + 1;
        // first col
        for (int i = 1; i <= n1 ; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1 ; i++) {
            for (int j = 1; j <= n2 ; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
            }
        }
        return dp[n1][n2];
    }
}
