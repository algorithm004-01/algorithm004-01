/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-22 07:43
 **/

public class Leetcode_714_371 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int res = maxProfit(prices, fee);
        System.out.println("res = " + res);
    }

    public static int maxProfit(int[] prices, int fee) {
        //dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+price)
        //dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-price-fee)
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
        }

        return dp_i_0;
    }
}
