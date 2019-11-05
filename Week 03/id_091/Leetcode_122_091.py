from typing import List


class Solution:
    #只要第二天的利润大于第一天就买进
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for i in range(0, len(prices)-1):
            tmp = prices[i+1] - prices[i]
            if tmp > 0: profit += tmp
        return profit


if __name__ == '__main__':
    solution = Solution()
    priceList = [7,1,5,3,6,4,8]
    res = solution.maxProfit(priceList)
    print(res)
