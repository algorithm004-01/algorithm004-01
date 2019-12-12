package com.lzhlyle.leetcode.self.no122;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        // base condition
        if (prices == null || prices.length < 2) return 0;

        // greedy
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) max = max + prices[i] - prices[i - 1];
        }
        return max;
    }
}
