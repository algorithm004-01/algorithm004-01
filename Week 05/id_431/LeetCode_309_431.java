package medium;

/**
 * @author 潘磊明
 * @date 2019/11/14
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    /**
     * 状态定义： 1维代表天数，2维代表买入，卖出
     * @param prices
     * @return
     */
//    public int maxProfit(int[] prices) {
//        if (prices.length == 0 || prices.length == 1) return 0;
//        int[][] dp = new int[prices.length][2];
//        //After you sell your stock, you cannot buy stock on next day
//        dp[0][0] = -prices[0];
//        dp[0][1] = 0;
//        dp[1][0] = Math.max(dp[0][0], -prices[1]);
//        dp[1][1] = Math.max(dp[0][1], dp[0][0] + prices[1]);
//        for (int i = 2; i < prices.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
//        }
//        return dp[prices.length - 1][1];
//    }

    /**
     * 简化代码
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int dp_0_0 = -prices[0];
        int dp_0_1 = 0;
        int dp_1_0 = Math.max(dp_0_0, -prices[1]);
        int dp_1_1 = Math.max(dp_0_1, dp_0_0 + prices[1]);
        for (int i = 2; i < prices.length; i++) {
            int tmp2 = dp_0_1;
            dp_0_0 = dp_1_0;
            dp_0_1 = dp_1_1;
            dp_1_0 = Math.max(dp_0_0, tmp2 - prices[i]);
            dp_1_1 = Math.max(dp_1_1, dp_0_0 + prices[i]);
        }
        return dp_1_1;
    }
}
