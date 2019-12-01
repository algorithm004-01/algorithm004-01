package hard;

/**
 * @author 潘磊明
 * @date 2019/11/14
 */
public class BestTimeToBuyAndSellStockIV {
    /**
     * 状态方程 一维天数，二维次数，三维买入卖出
     * @param k
     * @param prices
     * @return
     */
//    public int maxProfit(int k, int[] prices) {
//        if (prices.length == 0 || prices.length == 1 || k == 0) return 0;
//        if (k > prices.length / 2) return _maxProfit(prices);
//        int[][][] dp = new int[prices.length][k][2];
//        // init
//        for (int i = 0; i < k; i++) {
//            dp[0][i][0] = -prices[0];
//            dp[0][i][1] = 0;
//        }
//        for (int i = 1; i < prices.length; i++) {
//            for (int j = k - 1; j>=0; j--) {
//                if (j == 0) {
//                    dp[i][0][0] = Math.max(dp[i - 1][0][0], -prices[i]);
//                    dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] + prices[i]);
//                }else {
//                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] - prices[i]);
//                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] + prices[i]);
//                }
//            }
//        }
//        return dp[prices.length - 1][k - 1][1];
//    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || prices.length == 1 || k == 0) return 0;
        if (k > prices.length / 2) return _maxProfit(prices);
        int[][] dp = new int[k][2];
        for (int i = 0; i < k; i++) {
            dp[i][0] = -prices[0];
            dp[i][1] = 0;
        }
        int tmp;//记录前一天卖出的最大值
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
                    dp[j][0] = Math.max(dp[j][0], -prices[i]);
                    continue;
                }
                tmp = dp[j - 1][1];
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
                dp[j][0] = Math.max(dp[j][0], tmp - prices[i]);
            }
        }
        return dp[k - 1][1];
    }

    private int _maxProfit(int[] prices) {
        int dp_0_0 = -prices[0];
        int dp_0_1 = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = dp_0_1;
            dp_0_1 = Math.max(dp_0_1, dp_0_0 + prices[i]);
            dp_0_0 = Math.max(dp_0_0, tmp - prices[i]);
        }
        return dp_0_1;
    }
}
