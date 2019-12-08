
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
// 买卖股票的最佳时机 II

public class LeetCode_122_716 {
    // 1. 暴力法，太复杂了，先直接放弃

    // 2. 贪心法求解
    // 核心思想是：贪心的地方在于每次去寻找能够增加利润的值，前后两个价格做比较，只要产生收益就累加到
    // 最后的收益中，不能增加收益的就忽略掉
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) profit += diff;
        }
        return profit;
    }
}
