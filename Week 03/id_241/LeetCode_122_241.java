import java.util.*;
/**
 * 买卖股票的最佳时机 II
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1]) sum += prices[i] - prices[i - 1];
        return sum;
    }
}