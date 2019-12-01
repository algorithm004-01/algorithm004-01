# 只能拆分位数  最多2位  2位小于26
# 特殊情况 
# 以0结尾 大于26 直接返回0
# 两个相邻的0 直接返回0

class Solution:
    def numDecodings(self, s: str) -> int:
        if not s or s[0] == '0':
            return 0
        dp  = [None] * len(s)
        dp[0] = 1
        if len(s) > 1: 
            if s[1] == '0': 
                if int(s[0:2]) <= 26: 
                    dp[1] = 1 
                else:
                    return 0 # 此时该序列无法翻译
            else: 
                if int(s[0:2]) <= 26:
                    dp[1] = 2 
                else:
                    dp[1] = 1 # 只有一种结果

        for i in range(2, len(s)): # 从 2 开始
            if s[i] == '0': 
                if s[i-1] == '0': # 两个相邻的0
                    return 0 
                else: 
                    if int(s[i-1:i+1]) <= 26: 
                        dp[i] = dp[i-2]
                    else:  # 以0结尾 大于26 直接返回 0
                        return 0
            else: # s[i] 不为 ‘0’
                if s[i-1] == '0': # 前一个为 ‘0’
                    dp[i] = dp[i-1]
                else: # 前一个不为 ‘0’
                    if int(s[i-1:i+1]) <= 26: # s[i-1] 和 s[i] 组成的数 <= 26
                        dp[i] = dp[i-1] + dp[i-2]
                    else: # s[i-1] 和 s[i] 组成的数 > 26
                        dp[i] = dp[i-1]

        return dp[len(s) - 1]
