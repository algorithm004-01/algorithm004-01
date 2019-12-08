package week05;

/**
 *
 * 最长有效括号
 *
 * dp[i]=dp[i−2]+2
 * dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
 *
 * 复杂度分析
 *  时间复杂度： O(n)O(n) 。遍历整个字符串一次，就可以将 dpdp 数组求出来。
 *  空间复杂度： O(n)O(n) 。需要一个大小为 nn 的 dpdp 数组。
 *
 * @author tangzhenhua
 * @date 2019/11/17 21:12
 */
public class LeetCode_32_076 {


    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


}
