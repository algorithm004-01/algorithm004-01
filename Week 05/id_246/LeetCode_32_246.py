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

#stack
def longestValidParentheses_1(s):
    if not s: return 0
    res = 0
    stack = [-1]
    for i in range(len(s)):
        if s[i] == '(':
            stack.append(i)
            print(i, stack)
        else:
            stack.pop()
            print(i, stack)
            if not stack:
                stack.append(i)
                print(i, stack)
            else:
                res = max(res, i-stack[-1])
                print(i,stack,res)
    return res

#stack_2
def longestValidParentheses_2(s):
    stack = [0]
    longest = 0

    for c in s:
        if c == '(':
            stack.append(0)
        else:
            if len(stack)>1:
                val = stack.pop()
                stack[-1] += val+2
                longest = max(longest, stack[-1])
            else:
                stack = 0
    return longest


#dp
def longestValidParentheses_3(s):
    n = len(s)
    if n == 0: return 0
    dp = [0]*n
    res = 0
    for i in range(n):
        if i > 0 and s[i] == ')':
            if s[i-1] == '(':
                dp[i] = dp[i-2] + 2
            elif s[i-1] == ')' and i - dp[i - 1] - 1 >= 0 and s[i - dp[i - 1] - 1] == "(":
                dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
            if dp[i] > res:
                res = dp[i]
    return res