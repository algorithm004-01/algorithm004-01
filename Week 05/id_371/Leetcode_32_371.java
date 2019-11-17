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
     */
    public static int longestValidParentheses1(String s) {
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
