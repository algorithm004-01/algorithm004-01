package sf.week5;

import java.util.Arrays;

/**
 * Created by LynnSun on 2019/11/18.
 * 力扣题目地址：https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePathsDP {
    /**
     * 动态规划解法1 时间复杂度 O(m*n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 动态规划解法2 时间复杂度 O(m*n) 但空间复杂度比第一种解法低为 O(n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }
}
