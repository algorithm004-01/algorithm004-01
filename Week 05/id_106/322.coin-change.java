/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (32.15%)
 * Likes:    2452
 * Dislikes: 87
 * Total Accepted:    267.9K
 * Total Submissions: 826.2K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=0;i<amount+1;i++){
            dp[i] = amount+1;
        }
        dp[0] = 0;
        for (int i=1;i<=amount;++i){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[amount] > amount?-1:dp[amount]; 
    }
}
// @lc code=end
/**
 * dp
 * 1 子问题
 * 2 状态表示
 * 3 状态转移方程
 * 
 * 数组内为硬币的面值
 * f(amount) 表示得到当前amount时使用硬币的最小个数，等于当前最小个数加上减去当前面值后其余面值的最少个数
 * f(amount) = min(f(n-k) k in [coins]) + 1
 * 
 * 类似上台阶问题
 * 高度为0时走0步
 * 高度为1时走一步
 * 高度为2时走一个两步或者两个一步
 *       [1,2]
 *     dp[0,1,1,2,2,3,3]
 * index  0 1 2 3 4 5 6 
 * 
 * dp[i] = min(dp[i], dp[i-coins[j]] + 1)
 * 
 * 
 * BFS
 */

