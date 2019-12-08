class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices.length == 0) {
            return 0;
        }
        
        int sale = 0;
        int hold = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            int tempSale = sale;
            sale = Math.max(sale, hold + prices[i]);
            hold = Math.max(hold, tempSale - prices[i]);
        }
        
        return sale;
    }
}