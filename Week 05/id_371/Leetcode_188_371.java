/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-21 19:10
 **/

public class Leetcode_188_371 {

    /**
     * 仿解1:dp(自顶向上)
     *
     * @author Shaobo.Qian
     * @date 2019/11/21
     * @link https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
     * @question : 1.dp[i-2][0]-price,是正确的吗 临时变量
     */
    public int maxProfit(int max_k, int[] prices) { //k:交易的次数
        //dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+price)
        //dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-price)
        int n = prices.length;
        if (max_k > n / 2) return maxProfit_k_inf(prices);
        int[][][] dp = new int[n][max_k + 1][2]; //k+1,防止越界 k = 0 表示没有发生交易
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {// base case(说明处在第1天)
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i]; //第一天持有的代价
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }

        }
        return dp[n - 1][max_k][0];
    }

    private int maxProfit_k_inf(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;//第0天持有的代价

        for (int price : prices) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, temp - price);
        }

        return dp_i_0;
    }

/*
    public int maxProfit(int k, int[] prices) {
        //dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+price)
        //dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-price)

        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }

        return dp_i_0;
    }
*/

}
