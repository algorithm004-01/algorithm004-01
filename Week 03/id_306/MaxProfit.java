/**
 * Created by LynnSun on 2019/10/31.
 * 力扣题目地址：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        // 贪心算法
        // 求最优解
        /**因为现实中对股票价格的不可预测性，我们不可能真的乱买乱卖。
         * 但是程序有数据能预测我们只是做一个模拟的话是可以求出最优解的。
         * 比如 2 4 9，来说，我应该今天买后天卖，最优解为 9 - 2 = 7，
         * 那我就不能明天卖，应该后天卖，但是程序它不知道啊，
         * 我们这样想，明天卖早了说明我明天买后天在卖还是有钱赚，
         * 并且和后天卖的钱挣得是一样的即：9-4+4-2 = 7
         */
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }
}
