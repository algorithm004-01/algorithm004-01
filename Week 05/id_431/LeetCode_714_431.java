package medium;

/**
 * @author 潘磊明
 * @date 2019/11/14
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int dp_0_0 = -prices[0];
        int dp_0_1 = -fee;
        for (int i = 1; i < prices.length; i++) {
            int tmp = dp_0_1;
            dp_0_1 = Math.max(dp_0_1, dp_0_0 + prices[i] - fee);
            dp_0_0 = Math.max(dp_0_0, tmp - prices[i]);
        }
        return dp_0_1;
    }
}
