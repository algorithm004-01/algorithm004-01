/*
 * @lc app=leetcode.cn id=322 lang=javascript
 *
 * [322] 零钱兑换
 */

// @lc code=start
/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
    if(amount < 1) return 0;
    var dp = new Array(amount+1).fill(amount+1);
    dp[0] = 0;
    for(let i = 0; i <= amount; i++) {
        for(let r = 0; r < coins.length; r++) {
            if(coins[r] <= i) {
                dp[i] = Math.min(dp[i], dp[i - coins[r]] + 1);
            }
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
}
// @lc code=end

