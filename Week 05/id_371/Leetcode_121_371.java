/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-17 14:45
 **/

public class Leetcode_121_371 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = maxProfit1(prices);
        System.out.println("res = " + res);
    }
    /**
     * 仿解2: dp+降维度(注意一下状态转移方程，新状态只和相邻的一个状态有关，其实不用整个 dp 数组，只需要一个变量储存相邻的那个状态就足够了，这样可以把空间复杂度降到 O(1))
     * @author Shaobo.Qian
     * @date 2019/11/17
     */
    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            //2.状态转移方程
            // (从 dp[i-1]->dp[i][0]是如何转移的)-->现实含义,以更高的价格卖出股票
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // (从 dp[i-1]->dp[i][1]是如何转移的) -->现实含义,以更低的价格买入股票
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    /**
     * 仿解1:dp
     *
     * @author Shaobo.Qian
     * @date 2019/11/17
     * @link https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
     */
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        //1.定义需要维护的状态(如果状态之间相互影响,就需要同通过增加维度来表示)
        //1.1需要维护天数,下面 for 循环中的i
        //1.2需要维护是否持有 0:不持有 1:持有
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            //2.状态转移方程
            // (从 dp[i-1]->dp[i][0]是如何转移的)-->现实含义,以更高的价格卖出股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // (从 dp[i-1]->dp[i][1]是如何转移的) -->现实含义,以更低的价格买入股票
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 原解 dp(循环+记忆化-->自顶向下) -->未解除
     *
     * @author Shaobo.Qian
     * @date 2019/11/17
     */
    public int maxProfit(int[] prices) {
        //1.定义需要维护的状态(最大值索引要大于最小值索引)
        //1.1 最小值索引
        int minIndex = 0;
        int[] min = new int[]{};
        //1.2 最大值索引
        int maxIndex = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[maxIndex]) {
                maxIndex = i;
            } else if (prices[i] < prices[maxIndex]) {

            }
        }
        return 0;
    }
}
