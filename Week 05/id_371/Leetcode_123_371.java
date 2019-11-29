/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-17 17:48
 **/

public class Leetcode_123_371 {
    public static void main(String[] args) {
//        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
//        int[] prices = {1,2,3,4,5};
        int[] prices = {7, 6, 4, 3, 1};
        int res = maxProfit(prices);
        System.out.println("res = " + res);
    }

    /**
     * 仿解1:dp(自底向上)
     *
     * @author Shaobo.Qian
     * @date 2019/11/21
     * @link https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
     */
    public static int maxProfit(int[] prices) {
        //1.需要维护的状态:天数,是否持有,交易次数
        //状态转移方程:
        //dp[i][2][0] = Math.max(dp[i-1][2][0],dp[i-1][2][1]+price) ==>第二次卖出
        //dp[i][2][1] = Math.max(dp[i-1][2][1],dp[i-1][1][0]-price) ===>第二次买入,产生交易(k:1->2)
        //dp[i][1][0] = Math.max(dp[i-1][1][0],dp[i-1][1][1]+price) ==>第一次卖出
        //dp[i][1][1] = Math.max(dp[i-1][1][1],dp[i-1][0][0]-price) ===>第一次买入,产生交易(k:0->1)

        //1.初始化状态变量
        int dp_i10 = 0;//1.1记录第一次卖出产生的收益
        int dp_i11 = Integer.MIN_VALUE;//1.2第一次为了持有产生的代价
        int dp_i20 = 0;//1.3记录第二次卖出产生的收益
        int dp_i21 = Integer.MIN_VALUE;//1.4第二次持有产生的代价
        //自顶向上,状态变换方程
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }
/*
    public static int maxProfit(int[] prices) {
        //1.需要维护的状态:天数,是否持有,交易次数
        //状态转移方程:
        // dp[i][0] = Math.max(dp[i-1][0],dp[i-1][0] + prices[i])
        // dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0] - prices[i]
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
