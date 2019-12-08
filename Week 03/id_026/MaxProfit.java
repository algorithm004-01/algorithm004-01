package com.abc.week03;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit  = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i + 1] > prices[i]) {
                int temp = prices[i + 1] - prices[i];
                maxProfit += temp;
            }
        }
        return maxProfit;
    }
}
