/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-22 06:38
 **/

public class Leetcode_309_371 {

    public int maxProfit(int[] prices) {
        //dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+price)
        //dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-price)

        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);//每次 sell 之后要等一天才能继续交易,第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 ;即 dp[i-2][0]是持有的利润 - 今天的股票价格prices[i]
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }

}
