package Week5;

public class Leetcode_91_711 {
    public static void main(String[] args) {
        String s = "0";
        System.out.println(numDecodings1(s));
    }

    /**
     * 题解更优美写法
     * @param s
     * @return
     */
    private static int numDecodings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 2; i <= n ; i++) {
            int x = Integer.valueOf(s.substring(i - 1, i));
            int y = Integer.valueOf(s.substring(i - 2, i));
            if (x > 0) {
                dp[i] += dp[i - 1];
            }
            if (y > 9 && y < 27) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    /**
     * f[i] = f[i - 1] + f[i - 2](如果满足条件)
     * 执行用时 :3 ms, 在所有 java 提交中击败了47.93%的用户
     * 内存消耗 :36 MB, 在所有 java 提交中击败了28.73%的用户
     * @param s
     * @return
     */
    private static int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        if (Integer.parseInt(s.substring(0,1)) > 0)
            f[1] = 1;
        for (int i = 2; i <= n ; i++) {
            if (Integer.parseInt(s.substring(i - 1,i)) > 0) {
                f[i] = f[i - 1];
            }
            int x = Integer.valueOf(s.substring(i - 2, i));
            if (x > 9 && x < 27) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
