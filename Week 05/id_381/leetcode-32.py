# leetcode 32 最长有效括号

# 第一种用栈
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if not s:
            return 0
        max_num = 0
        stack = [-1]    # 哨兵，很重要
        for i in range(len(s)):
            if s[i] == '(':
                # 压入栈中去
                stack.append(i)
            else:
                # 先不管其他，先pop一个出去
                stack.pop()
                # 如果pop后还有，那就表明')'，是有'('匹配的，也就是上一步pop出来的是一个'('
                # 如果pop后stack=[]，那就表明，没有'('匹配，也就是上衣步pop出来的是前面的哨兵，比如最开始压入的-1
                if stack:
                    # 能匹配上，那么最大长度就是当前的下表i-stack最后的一个值
                    max_num = max(max_num, i-stack[-1])
                else:
                    # 不能匹配上，那么就从当前位置开始再重新计算
                    stack.append(i)
        return max_num
        
# 第二种 动态规划

class Solution:
    def longestValidParentheses(self, s: str) -> int:
        max_num = 0
        dp = [0]*len(s)
        for i in range(1, len(s)):
            # 只需要判断为')'
            if s[i] == ')':
                # 分两种情况，两个子问题
                if s[i-1] == '(':
                    dp[i] = dp[i-2] + 2 if i > 1 else 2
                elif s[i-1] == ')':
                    j = i - dp[i-1] - 1
                    # 需要判断是否>0
                    if j >= 0:
                        if s[j] == '(':
                            dp[i] = dp[j-1] + dp[i-1] + 2
            max_num = max(dp[i], max_num)
        return max_num
