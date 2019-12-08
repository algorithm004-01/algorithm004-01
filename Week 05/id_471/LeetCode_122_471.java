class Solution {
    /*
    动态规划法
    考虑买和卖两个状态
    定义重复子问题：在第 i 天的买卖情况可以由前一天的买卖状态来决定，然后择优决定买或者卖掉
    动态规划方程：sale[i] = Math.max(sale[i - 1], buy[i-1] + prices[i])
    buy[i] = Math.max(buy[i-1], sale[i-1] + prices[i])
    */
    
    public int maxProfit(int[] prices) {
        int sale = 0, buy = Integer.MIN_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            buy = Math.max(buy, sale - prices[i]);
            sale = Math.max(sale, buy + prices[i]);
        }
        
        return sale;
    }
}