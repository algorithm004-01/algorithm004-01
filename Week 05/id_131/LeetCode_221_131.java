package com.lzhlyle.leetcode.self.no221;

public class MaximalSquare_2 {
    public int maximalSquare(char[][] matrix) {
        // base condition
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int width = matrix[0].length;
        int maxSide = 0;

        int[] dp = new int[width + 1];
        int northwest = 0;

        for (char[] chars : matrix) {
            for (int j = 0; j < width; j++) {
                int nextNorthwest = dp[j + 1];
                if (chars[j] == '1') {
                    dp[j + 1] = Math.min(Math.min(dp[j], dp[j + 1]), northwest) + 1;
                    maxSide = Math.max(maxSide, dp[j + 1]);
                } else {
                    dp[j + 1] = 0;
                }
                northwest = nextNorthwest;
            }
        }

        return maxSide * maxSide;
    }
}
