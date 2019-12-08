'''
wildcard-matching_44

给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。

'''

#指针
def isMatch_1(s, p):
    i = 0
    j = 0
    start = -1
    match = 0
    while i < len(s):
        # 一对一匹配,匹配成功一起移
        if j < len(p) and (s[i] == p[j] or p[j] == "?"):
            i += 1
            j += 1
        # 记录p的"*"的位置,还有s的位置
        elif j < len(p) and p[j] == "*":
            start = j
            match = i
            j += 1
        # j 回到 记录的下一个位置
         # match 更新下一个位置
         # 这不代表用*匹配一个字符
        elif start != -1:
            j = start + 1
            match += 1
            i = match
        else:
            return False
         # 将多余的 * 直接匹配空串
    return all(x == "*" for x in p[j:])


#dp
def isMatch_2(s, p):
    sn, pn = len(s), len(p)
    dp = [[False]*(pn+1) for _ in range(sn+1)]
    dp[0][0] = True
    for j in range(1, pn+1):
        if p[j-1] == '*':
            dp[0][j] = dp[0][j-1]
    for i in range(1, sn+1):
        for j in range(1, pn+1):
            if (s[i-1] == p[i-1] or p[i-1] == '?'):
                dp[i][j] = dp[i-1][j-1]
            elif p[j-1] == '*':
                dp[i][j] = dp[i-1][j] or dp[i][j-1]
    return dp[-1][-1]