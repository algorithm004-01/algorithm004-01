# 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
#
# 示例 1: 
#
# 输入: "(()"
# 输出: 2
# 解释: 最长有效括号子串为 "()"
# 
#
# 示例 2: 
#
# 输入: ")()())"
# 输出: 4
# 解释: 最长有效括号子串为 "()()"
# 
# Related Topics 字符串 动态规划

"""
1、 暴力法
2、 stack 方法
3、 DP
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        max_len = 0
        for i in range(len(s)):
            for j in range(i + 2, len(s) + 1, 2):
                if self.isValid(s[i:j]):
                    max_len = max(j - i, max_len)
        return max_len

    def isValid(self, s):
        stack = []
        for c in s:
            if c == '(':
                stack.append('(')
            elif stack:
                stack.pop()
            else:
                return False
        return not stack


class Solution2(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = [-1]
        max_len = 0
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                stack.pop()
                if not stack:
                    stack.append(i)
                else:
                    max_len = max(max_len, i - stack[-1])
        return max_len


# DP
class Solution3(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        """
        DP
        a. 重复性 
            if s(i) is ')':
                if s(i - 1) is '(':
                    problem(i) = sub(i - 2) + 2
                if i - sub(i - 1) > 0 and s[i - sub[i - 1] - 1] == '(':
                    problem(i) = sub(i - 1) + sub(i - sub(i - 1) - 2) + 2
        b. 定义状态数组 f[i]
        c. dp方程
            if s[i] == ')':
                if s[i - 1] == '(':
                    dp[i] = dp[i - 2] + 2
                elif i - dp[i - 1] > 0 and s[i - dp[i - 1] - 1] == '(':
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2                  
        """
        dp = [0] * len(s)
        max_len = 0
        for i in range(1, len(s)):
            if s[i] == ')':
                if s[i - 1] == '(':
                    dp[i] = dp[i - 2] + 2
                elif i - dp[i - 1] > 0 and s[i - dp[i - 1] - 1] == '(':
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
            max_len = max(max_len, dp[i])
        return max_len


if __name__ == '__main__':
    S = Solution2()
    s = ')()'
    print(S.longestValidParentheses(s))
