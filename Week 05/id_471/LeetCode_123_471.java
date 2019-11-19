class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int buy = -prices[0];
        int sales[] = new int[prices.length];
        buy = -prices[0];
        sales[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            sales[i] = Math.max(sales[i - 1], buy + prices[i]);
            buy = Math.max(buy, -prices[i]);
        }
        
        int maxProfit = sales[sales.length-1];
        int maxPrice = prices[prices.length - 1];
        
        for (int i = prices.length - 2; i >= 1; i--) {
            maxProfit = Math.max(maxProfit, maxPrice - prices[i] + sales[i-1]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }
        
        return maxProfit;
    }
}