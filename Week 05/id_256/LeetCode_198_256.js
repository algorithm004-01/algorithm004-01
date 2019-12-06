/*
 * @lc app=leetcode.cn id=198 lang=javascript
 *
 * [198] 打家劫舍
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    // 方案一 不理解
    // let currMax = 0;
    // let prevMax = 0;
    // for(let key in nums) {
    //     let temp = currMax;
    //     currMax = Math.max(prevMax + nums[key], currMax);
    //     prevMax = temp;
    // }
    // return currMax;
  
    //DP
    let len = nums.length;
    if (len == 0) return 0;
    let dp = new Array(len + 1);
    dp[0] = 0;
    dp[1] = nums[0];
    for (let i = 2; i <= len; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
    }
    return dp[len];
  };
  // @lc code=end
  