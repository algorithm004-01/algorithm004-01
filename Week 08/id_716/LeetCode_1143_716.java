public class LeetCode_1143_716 {
    // dp
    public int longestCommonSubsequence1(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        if (text1.isEmpty() || text2.isEmpty()) return 0;

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
    
    // 2. dp opt
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length() + 1, n = text2.length() + 1;
        int[] dp = new int[n];
        char[] text1Arr = ("#" + text1).toCharArray();
        char[] text2Arr = ("#" + text2).toCharArray();
        int temp, now;
        for (int i = 1; i < m; i++) {
            temp = 0;
            for (int j = 1; j < n; j++) {
                // 记录(i-1, j-1)位置的最长子序列长度
                now = dp[j];
                if (text1Arr[i] == text2Arr[j]) {
                    // 要去 (i-1, j-1) 位置的值
                    dp[j] = temp + 1;
                } else {
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }
                // 记录(i-1, j-1)位置的最长子序列长度，传递到(i,j)
                temp = now;
            }
        }
        return dp[n-1];
    }
}