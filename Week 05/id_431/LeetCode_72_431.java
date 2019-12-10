package hard;

/**
 * @author 潘磊明
 * @date 2019/11/15
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp = new int[w1.length][w2.length];
        //init
        if (w1[0] == w2[0]) dp[0][0] = 0;
        else dp[0][0] = 1;
        for (int i = 1; i < w1.length; i++) {
            if (w1[i] == w2[0]) dp[i][0] = i;
            else dp[i][0] = dp[i - 1][0] < i ? i : i + 1;
        }
        for (int j = 1; j < w2.length; j++) {
            if (w2[j] == w1[0]) dp[0][j] = j;
            else dp[0][j] = dp[0][j - 1] < j  ? j : j + 1;
        }
        for (int i = 1; i < w1.length; i++) {
            for (int j = 1; j < w2.length; j++) {
                if (w1[i] == w2[j]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[w1.length - 1][w2.length - 1];
    }

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        EditDistance e = new EditDistance();
        e.minDistance(s1, s2);
    }
}
