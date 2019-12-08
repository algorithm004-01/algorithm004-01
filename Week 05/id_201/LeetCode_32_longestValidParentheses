package com.ann.leetCode.medium;

import java.util.Stack;

public class LeetCode32LongestValidParenthese {
    public int longestValidParentheses(String s) {
        int longestV = 0;
        Stack<Integer> st = new Stack();
        st.push(-1);
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    longestV = Math.max(longestV, i - st.peek());
                }
            }
        }
        return longestV;
    }

    /**
     * dp
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        int maxN = 0;
        int[] validParenthesesLen = new int[s.length()];
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')' && i - validParenthesesLen[i - 1] >= 1 && s.charAt(i - validParenthesesLen[i - 1] - 1) == '(') {
                validParenthesesLen[i] = validParenthesesLen[i - 1] + 2 + (i - validParenthesesLen[i - 1] >= 2 ? validParenthesesLen[i - validParenthesesLen[i - 1] - 2]: 0);
                maxN = Math.max(maxN, validParenthesesLen[i]);
            }
        }
        return maxN;
    }
}
