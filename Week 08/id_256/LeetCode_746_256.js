/*
 * @lc app=leetcode.cn id=746 lang=javascript
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    //DP
    if(cost.length <= 1) return 0;
    if(cost.length == 2) {
        return Math.min(cost[0], cost[1]);
    }
    for(let i = 2; i < cost.length; i++) {
        cost[i] += Math.min(cost[i-2], cost[i-1]);
    }
    return Math.min(cost[cost.length-2], cost[cost.length-1]);
};
// @lc code=end

