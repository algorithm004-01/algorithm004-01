/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-17 21:33
 **/

public class Leetcode_32_371 {
    public static void main(String[] args) {

//        String s = ")()())";
//        String s = "(()";
        String s = "()(())";
        System.out.println("s = " + longestValidParentheses1(s));

    }


    /**
     * 仿解1:
     *
     * @author Shaobo.Qian
     * @date 2019/11/17
     * @link https://leetcode.com/problems/longest-valid-parentheses/discuss/14278/Two-Java-solutions-with-explanation.-Stack-and-DP.-Short-and-easy-to-understand.
     * @key 状态转移方程是如何推导出来的?
     */
    public static int longestValidParentheses1(String s) {
        int len = s.length();
        //1.定义需要维护的状态
        int[] dp = new int[len];
        int result = 0;
        int leftCount = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (chars[i] == '(') {
                leftCount++;
            } else if (leftCount > 0) {
                dp[i] = dp[i - 1] + 2;
                dp[i] += i - dp[i] >= 0 ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

    /**
     * 原解:dp (未解出)
     *
     * @author Shaobo.Qian
     * @date 2019/11/17
     */
    public static int longestValidParentheses(String s) {
        //1.定义需要维护的状态
        //1.1 最长有效字符长度
        int max = 0;
        //1.2当前字符为终点的到上一个无效字符之间的最大有效字符长度
        int currMax = 0;
        //1.3左括号的个数
        int leftCount = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                leftCount++;
            } else {
                if (leftCount == 0) {
                    currMax = 0;
                } else {
                    currMax += 2;
                    leftCount--;
                    max = Math.max(max, currMax);
                }
            }
        }
       /* for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')' && chars[i - 1] == '(') {
                currMax += 2;
                max = Math.max(max, currMax);
            } else if (chars[i] == '(') {
                continue;
            } else {
                currMax = 0;
            }
        }*/

        return max;
    }
}
