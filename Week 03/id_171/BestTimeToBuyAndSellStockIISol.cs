namespace Poplar.Algorithm.WeekThree
{
    /// <summary>
    /// 买卖股票最佳时机II
    /// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
    /// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
    /// </summary>
    public class BestTimeToBuyAndSellStockIISol
    {
        public int MaxProfit(int[] prices)
        {
            //return PeakValley(prices);
            return Greedy(prices);
        }

        /// <summary>
        /// 峰谷法，在谷买，在峰卖，减少购买次数
        /// </summary>
        /// <param name="prices"></param>
        /// <returns></returns>
        public int PeakValley(int[] prices)
        {
            var i = 0;
            var profit = 0;
            while (i < prices.Length - 1)
            {
                while (i < prices.Length - 1 && prices[i] >= prices[i + 1])
                {
                    i++;
                }
                var buy = prices[i];
                while (i < prices.Length - 1 && prices[i] <= prices[i + 1])
                {
                    i++;
                }
                var sell = prices[i];
                profit += sell - buy;
            }
            return profit;
        }

        /// <summary>
        /// 贪心算法，只要今天价格比明天高，就在今天买明天卖
        /// </summary>
        /// <param name="prices"></param>
        /// <returns></returns>
        private int Greedy(int[] prices)
        {
            var profit = 0;
            for (int i = 0; i < prices.Length - 1; i++)
            {
                if (prices[i] < prices[i + 1])
                {
                    profit += prices[i + 1] - prices[i];
                }
            }
            return profit;
        }
    }
}
