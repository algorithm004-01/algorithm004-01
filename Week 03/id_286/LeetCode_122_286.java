package com.uanei;

public class LeetCode_122_286 {

    /**
     * 贪心算法：只要后边比前边大，前一天就买，后一天就卖
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max = max + (prices[i] - prices[i - 1]);
            }
        }
        return max;
    }

}
