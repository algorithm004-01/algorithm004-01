'''
best-time-to-buy-and-sell-stock-ii_122

给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例:
输入: [7,1,5,3,6,4]
输出: 7
'''

def maxProfit(prices):
    profit = 0
    for i in range(1, len(prices)):
        tmp = prices[i] - prices[i-1]
        if tmp > 0: profit += tmp
    return profit


#优化
def maxProfit_2(prices):
    return sum(max(prices[i+1]-prices[i], 0) for i in range(len(prices) - 1))