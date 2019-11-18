/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int len = prices.length;
        for (int i = 0; i < len-1; i++) {
            res += Math.max(prices[i+1] - prices[i], 0);

        }
        return res;
        
    }
}
// @lc code=end

