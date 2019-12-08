package homework.week05;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @author sintang
 * @date 2019-11-17
 */
public class LeetCode_32_501 {
    /**
     * 暴力法使用栈处理
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        for(int i = 0;i < s.length();i++){
            for(int j = i + 2;j <= s.length(); j+=2){
                if(isValid(s.substring(i,j))){
                    maxLength = Math.max(maxLength,j - i);
                }
            }
        }
        return maxLength;
    }
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push('(');
            }else if(!stack.empty() && stack.peek() == '('){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.empty();
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s){
        int maxlength = 0;
        int[] dp =new int[s.length()];
        for (int i = 1; i < s.length() ; i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i-1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1])>=2 ? dp[i - dp[i -1] -2] :0) +2;
                }
                maxlength = Math.max(maxlength,dp[i]);
            }
        }
        return maxlength;
    }


    public static void main(String[] args) {
        LeetCode_32_501 leetcode = new LeetCode_32_501();
        System.out.println(leetcode.longestValidParentheses("()(()"));
        System.out.println(leetcode.longestValidParentheses2("()(()"));
    }
}
