/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                max += prices[i] -prices[i-1];
            }
        }
        return max;
    }
}
// @lc code=end

