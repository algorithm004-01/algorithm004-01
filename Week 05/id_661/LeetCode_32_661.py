#!/usr/bin/env python3.7


class Solution:
    def longestValidParentheses(self, s):
        dp, stack = [0] * (len(s) + 1), []
        for i in range(len(s)):
            if s[i] == "(":
                stack.append(i)
            else:
                if stack:
                    p = stack.pop()
                    dp[i + 1] = dp[p] + i - p + 1
        return max(dp)


test = "(()"
print(Solution().longestValidParentheses(test))
