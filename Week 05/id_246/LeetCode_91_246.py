'''
decode-ways_91

一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:
输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。

示例 2:
输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
'''

#dp_1
def numDecodings_1(s):
    if not s or s[0] == '0':
        return 0
    dp = [None] * len(s)
    dp[0] = 1
    if len(s) > 1:
        if s[1] == '0':
            if int(s[0:2]) <= 26:
                dp[1] = 1
            else:
                return 0
        else:
            if int(s[0:2]) <= 26:
                dp[1] = 2
            else:
                dp[1] = 1
    else:
        return 1

    for i in range(2, len(s)):
        if s[i] == '0':
            if s[i-1] == '0':
                return 0
            else:
                if int(s[i-1:i+1]) <= 26:
                    dp[i] = dp[i-2]
                else:
                    return 0
        else:
            if s[i-1] == '0':
                dp[i] = dp[i-1]
            else:
                if int(s[i-1:i+1]) <= 26: # s[i-1] 和 s[i] 组成的数 <= 26
                    dp[i] = dp[i-1] + dp[i-2]
                else:
                    dp[i] = dp[i-1]

    return dp[len(s)-1]

#dp_2
def numDecodings_2(s):
    pp, p = 1, int(s[0] != '0')
    for i in range(1, len(s)):
        pp, p = p, pp*(9< int(s[i-1:i+1]) <= 26) + p*(int(s[i]) >0)
    return p
