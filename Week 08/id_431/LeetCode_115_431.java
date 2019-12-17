package hard;

/**
 * @author 潘磊明
 * @date 2019/12/10
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();
        int[][] dp = new int[tarray.length + 1][sarray.length + 1];
        for (int i = 0; i < sarray.length + 1; i++) dp[0][i] = 1; //空字符串是所有字符串的子序列
        for (int i = 1; i < tarray.length + 1; i++) {
            for (int j = 1; j < sarray.length + 1; j++) {
                if (tarray[i - 1] == sarray[j - 1]) dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[tarray.length][sarray.length];
    }
}
