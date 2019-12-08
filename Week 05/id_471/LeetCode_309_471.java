class Solution {
    //sale[i] = Math.max(sale[i-1], buy[i-1] + prices[i]);
    //buy[i] = Math.max(buy[i-1], sale[i-2] - prices[i]);
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        
        int sales = 0, buy = -prices[0], preSales = 0;
        
        for (int i = 1; i < prices.length; i++) {
            int temp = sales;
            sales = Math.max(sales, buy + prices[i]);
            buy = Math.max(buy, preSales - prices[i]);
            preSales = temp;
        }
        
        return sales;
    }
}