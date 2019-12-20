package sf.week8;

/**
 * Created by LynnSun on 2019/12/6.
 * 力扣题目地址：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 */
public class SellStockFour {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 1 || k < 1) {
            return 0;
        }
        if (k > prices.length >> 1) {
            return maxProfit(prices);
        }
        // 初始化 dp 数组,第 i 天，第 k 笔 交易，是否持有股票,1 持有，0 不持有
        int[][][] mp = new int[prices.length][k + 1][2];
        // 初始化第一天数据，买入股票
        for (int i = 1; i < k+1; i++) {
            mp[0][i][1] = -prices[0];
        }
        // 依次递归最大收益
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                // 第 i 天，第 j 笔 交易，不持有股票的最大值=
                // 前一天持有股票今天卖出 / 前一天不持有股票，保持不变
                mp[i][j][0] = Math.max(mp[i - 1][j][0], mp[i - 1][j][1] + prices[i]);
                // 第 i 天，第 j 笔 交易，持有股票的最大值=
                // 前一天不持有股票今天买入 / 前一天持有股票，保持不变
                mp[i][j][1] = Math.max(mp[i - 1][j][1], mp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return mp[prices.length - 1][k][0]; // 最大利润
    }
    // 不限制交易次数
    public int maxProfit(int[] prices) {
        int profit = 0;
        // 贪婪算法，存在利润就卖出
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
