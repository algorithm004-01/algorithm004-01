//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
// 示例 1:
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//
//
// 示例 2:
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
//
// Related Topics 字符串 动态规划
package com.aseara.leetcode.editor.cn.a32;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 32.最长有效括号 <br />
 * Date: 2019/11/14 <br/>
 *
 * @author qiujingde
 */
class LongestValidParentheses {
    private Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals(2, solution.longestValidParentheses("(()"));
        assertEquals(4, solution.longestValidParentheses(")()())"));
        assertEquals(2, solution.longestValidParentheses("()(()"));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        // 检查判断某个位置是否合法
        int[] memo = new int[s.length() + 1];
        char[] chars = s.toCharArray();
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                memo[stack.pop()] = 1;
                memo[i] = 1;
            }
        }

        int max = 0;
        for (int i = 1; i < memo.length; i++) {
            if (memo[i] == 0) {
                max = Math.max(max, memo[i - 1]);
            } else {
                memo[i] = memo[i - 1] + 1;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
