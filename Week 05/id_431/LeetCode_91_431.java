package medium;

/**
 * @author 潘磊明
 * @date 2019/11/18
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        if (s.length() == 1) return 1;
        int[] array = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            array[i] = Integer.valueOf(s.substring(i, i + 1));
        }
        int[] dp = new int[array.length];
        dp[0] = 1;

        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] == 0) dp[i] = 0;
            else if (array[i] == 0) {
                if(array[i - 1] == 1 || array[i - 1] == 2) {
                    if (i != 1) dp[i] = dp[i - 2];
                    else dp[i] = 1;
                }
                else dp[i] = 0;
            }
            else {
                int tmp = array[i - 1] * 10 + array[i];
                if (tmp > 10 && tmp < 27) {
                    if (i == 1) dp[i] = 2;
                    else dp[i] = dp[i - 1] + dp[i - 2];
                }
                else dp[i] = dp[i - 1];
            }
        }
        return dp[array.length - 1];
    }
}
