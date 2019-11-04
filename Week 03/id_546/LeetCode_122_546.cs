using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Easy
{
    /// <summary>
    /// 122. 买卖股票的最佳时机 II
    /// </summary>
    public class BestTimeToBuyAndSellStockii
    {
        public int MaxProfit(int[] prices)
        {
            int total = 0;
            for (int i = 0; i < prices.Length - 1; i++)
            {
                if (prices[i + 1] > prices[i])
                {
                    total += prices[i + 1] - prices[i];
                }
            }

            return total;
        }
    }
}
