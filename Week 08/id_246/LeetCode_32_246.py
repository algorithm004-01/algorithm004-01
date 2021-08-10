'''
longest-valid-parentheses_32

给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
'''

def longestValidParentheses(s):
    if (not s):
        return 0
    res = 0
    n = len(s)
    dp = [0] * n
    for i in range(1, n):
        if (s[i] == '('):
            if (s[i-1] == '('):
                dp[i] = dp[i-2] + 2
            if (s[i-1] == ')' and i-dp[i-1]-1 >= 0 and s[i-dp[i-1]-1] == '('):
                dp[i] = dp[i-1]+dp[i-dp[i-1]-2]+2
            res = max(res, dp[i])
    return res