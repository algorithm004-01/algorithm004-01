#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#

# @lc code=start
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = [-1]
        res = 0
        for i in range(len(s)):
            c = s[i]
            if c == ')' and stack[-1] != -1 and s[stack[-1]] == '(':
                stack.pop()
                res = max(i-stack[-1], res)
            else:
                stack.append(i)
        return res
        
# @lc code=end

