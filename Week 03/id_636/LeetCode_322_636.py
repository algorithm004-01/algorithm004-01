'''
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。

链接：https://leetcode-cn.com/problems/coin-change。
'''


class List(list):
    pass

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # inport
        import collections
        dp = collections.defaultdict(lambda: 0)

        for index in range(1, amount + 1):
            cost = float('inf')
            for coin in coins:
                if coin <= index:
                    cost = min(cost, dp[index - coin] + 1)
                dp[index] = cost

        return -1 if dp[amount] == float('inf') else dp[amount]

