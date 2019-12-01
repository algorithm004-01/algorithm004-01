class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if (not s):
            return 0
        res = 0
        n = len(s)
        dp = [0] * n
        for i in range(1, len(s)):
            if (s[i] == ")"):
                if (s[i - 1] == "("):
                    dp[i] = dp[i - 2] + 2
                if (s[i - 1] == ")" and i - dp[i - 1] - 1 >= 0 and s[i - dp[i - 1] - 1] == "("):
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
                res = max(res, dp[i])
        return res
