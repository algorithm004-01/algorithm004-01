package com.uanei;

public class LeetCode_1143_286 {

    public int longestCommonSubsequence(String text1, String text2) {
        // 解题技巧：二维 -- 行列排列
        // [*,a,b,c,d]
        // [c,*,*,*,*]
        // [f,*,*,*,*]
        // [e,*,*,*,*]
        // [g,*,*,*,*]

        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        // 定义中间状态
        int[][] dp = new int[s1.length + 1][s2.length + 1];

        for (int i = 1; i < s1.length + 1; i++) {
            for (int j = 1; j < s2.length + 1; j++) {
                // 如果最后一个字符相同，前边的子结果+1
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 如果最后一个字符不相同，去掉行或列的字符，求子结果
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length][s2.length];
    }

}
