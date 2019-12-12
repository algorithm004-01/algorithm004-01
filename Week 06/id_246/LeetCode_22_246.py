'''
generate-parentheses_22

给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
'''

def generateParenthesis(N):
    ans = []
    def backtrack(S='', left=0, right=0):
        if len(S) == 2*N:
            ans.append(S)
            return
        if left < N:
            backtrack(S+'(', left+1, right)
        if right < left:
            backtrack(S+')', left, right+1)

    backtrack()
    return ans