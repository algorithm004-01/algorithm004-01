package sf.week8;

/**
 * Created by LynnSun on 2019/12/6.
 * 力扣题目地址：https://leetcode-cn.com/problems/edit-distance/
 */
public class LongestValidParentheses {

    /**
     * 动态规划 一维数组
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // 右括号前边是左括号
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    // 右括号前边是右括号，并且除去前边的合法序列的前边是左括号
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    /**
     * 神奇的解法 看题解看到的 很有意思
     * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-7/
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
