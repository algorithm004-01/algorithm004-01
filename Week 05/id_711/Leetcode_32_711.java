package Week5;

public class Leetcode_32_711 {
    public static void main(String[] args) {
        String s = "))(()(()()";
        System.out.println(longestValidParentheses(s));
    }

    /**
     * 草稿纸上写写画画想出来拉。
     *
     * 执行用时 :3 ms, 在所有 java 提交中击败了82.01%的用户
     * 内存消耗 :37.1 MB, 在所有 java 提交中击败了84.11%的用户
     * @param s
     * @return
     */
    private static int longestValidParentheses(String s) {
        int ans = 0;
        int n = s.length();
        int[] f = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '(') {
                f[i] = 0;
            }
            else {
                if (s.charAt(i - 1) == '(') {
                    f[i] = 2;
                    if (i - 2 > 0) {
                        f[i] += f[i - 2];
                    }
                }
                else {
                    int len = f[i - 1];
                    if (i - len > 0) {
                        if (s.charAt(i - len - 1) == '(') {
                            f[i] = f[i - 1] + 2;
                            if (i - len - 2 > 0) {
                                f[i] += f[i - len - 2];
                            }
                        }
                    }
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
