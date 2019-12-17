package id_576;

public class LeetCode_5_576 {

    /**
     * 1. brute 嵌套循环，枚举 i， j（起点和终点），判断子串是否是回文串, O(n^3)
     * 2. 枚举中心，向两边扩张O(n^2)
     * 3. DP
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) &&
                        (j - i < 2 || dp[i + 1][j - 1]);

                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private int lo, maxlen;
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i); // odd length
            extendPalindrome(s, i, i + 1); // even length
        }

        return s.substring(lo, lo + maxlen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--; k++;
        }

        if (maxlen < k - j - 1) {
            lo = j + 1;
            maxlen = k - j - 1;
        }
    }


}
