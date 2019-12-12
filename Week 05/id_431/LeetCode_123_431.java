package hard;

/**
 * @author 潘磊明
 * @date 2019/11/13
 */
public class BestTimetoBuyandSellStockIII {
//    public int maxProfit(int[] prices) {
//        if (prices.length == 0) return 0;
//        /**
//         * 状态方程，1维是天数，2维是买卖次数，3维是买卖状态  0买入1卖出
//         */
//        int[][][] dp = new int[prices.length][2][2];
//        dp[0][0][0] = -prices[0];
//        dp[0][0][1] = 0;
//        dp[0][1][0] = Integer.MIN_VALUE;
//        dp[0][1][1] = Integer.MIN_VALUE;
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][0][0] = Math.max(dp[i - 1][0][0], -prices[i]);
//            dp[i][0][1] = Math.max(dp[i - 1][0][0] + prices[i], dp[i - 1][0][1]);
//            dp[i][1][0] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][0]);
//            dp[i][1][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][1][1]);
//        }
//        return Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][1][1]);
//    }

    /**
     * 简化代码
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int dp_i_0_0 = -prices[0];
        int dp_i_0_1 = 0;
        int dp_i_1_0 = Integer.MIN_VALUE;
        int dp_i_1_1 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp_i_1_1 = Math.max(dp_i_1_1, dp_i_1_0 + prices[i]);
            dp_i_1_0 = Math.max(dp_i_1_0, dp_i_0_1 - prices[i]);
            dp_i_0_1 = Math.max(dp_i_0_1, dp_i_0_0 + prices[i]);
            dp_i_0_0 = Math.max(dp_i_0_0, -prices[i]);
        }
        return Math.max(dp_i_0_1, dp_i_1_1);
    }
}
