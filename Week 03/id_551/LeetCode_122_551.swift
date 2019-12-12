class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        // 贪心算法
        // 贪心前提：每天只要涨就买卖，跌就不买卖，榨干每一次上涨，最终得到最优解
        // 子过程： if prices[i] > prices[i -1] { profit += xx }
        
        if prices.count < 2 { 
            // 少于 2 个价格，无意义
            return 0 
        }
        
        var profit = 0
        for i in 1..<prices.count {
            if prices[i] > prices[i - 1] {
                profit += prices[i] - prices[i - 1]
            }
        }
        return profit
    }
}
