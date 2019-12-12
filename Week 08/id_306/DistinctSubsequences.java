package sf.week8;

/**
 * Created by LynnSun on 2019/12/7.
 * 力扣题目地址：https://leetcode-cn.com/problems/distinct-subsequences
 */
public class DistinctSubsequences {
    /**
     * 还行 没太懂
     * 出处：https://leetcode-cn.com/problems/distinct-subsequences/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-27
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();
        int[] dp = new int[s_len + 1];
        for (int i = 0; i <= s_len; i++) {
            dp[i] = 1;
        }
        for (int t_i = 1; t_i <= t_len; t_i++) {
            int pre = dp[0];
            dp[0] = 0;
            for (int s_i = 1; s_i <= s_len; s_i++) {
                int temp = dp[s_i];
                if (t.charAt(t_i - 1) == s.charAt(s_i - 1)) {
                    dp[s_i] = dp[s_i - 1] + pre;
                } else {
                    dp[s_i] = dp[s_i - 1];
                }
                pre = temp;
            }
        }
        return dp[s_len];
    }

    /**
     * 没看懂 需要细品
     * 出处：https://leetcode-cn.com/problems/distinct-subsequences/solution/dong-tai-gui-hua-by-powcai-5
     * @param s
     * @param t
     * @return
     */
    public int numDistinct1(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++) dp[0][j] = 1;
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[t.length()][s.length()];
    }
}
