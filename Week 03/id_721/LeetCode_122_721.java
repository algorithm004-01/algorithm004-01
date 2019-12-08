package greedy;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 */
public class LC_122_StockTradeMaxProfit {

    /**
     * 11:34 AM	info
     * Success:
     * Runtime:1 ms,faster than 99.99% of Java online submissions.
     * Memory Usage:36.7 MB, less than 93.36% of Java online submissions.
     * 最大股票收益：
     * 思路：如果前一天价格比后一天低，买入，并且在第二天卖出，并且继续走买入逻辑，判断当天低价格是否比后一天低(天眼模式)
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 0) return profit;
        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length && prices[i + 1] - prices[i] > 0) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
