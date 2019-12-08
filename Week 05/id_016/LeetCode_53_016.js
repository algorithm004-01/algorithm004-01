/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-11-17 20:56:16
 * @LastEditTime: 2019-11-17 21:20:42
 */
/*
 * @lc app=leetcode id=53 lang=javascript
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (44.75%)
 * Likes:    5502
 * Dislikes: 234
 * Total Accepted:    688.1K
 * Total Submissions: 1.5M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */
// @lc code=start
/**
1.暴力求解,超时 时间复杂度是 O(n^2)
2.动态规划 dp[i] = max((dp[i-1] +nums[i]),nums[i])
 * @param {number[]} nums
 * @return {number}
 */
// var maxSubArray = function(nums) {
//     let len = nums.length;
//     let res = -Infinity;
//     for (let i = len; i > 0; i--) {
//       let flag = true;
//       let left = 1;
//       let right = i;
//       while (flag) {
//         let cur = nums.slice(left - 1, right);
//         res = Math.max(
//           cur.reduce((prev, c) => prev + c, 0),
//           res
//         );
//         left++;
//         right++;
//         if (right > len) flag = false;
//       }
//     }
//     return res;
// };
var maxSubArray = function(nums) {
  let dp = [];
  dp[0] = nums[0];
  let res = nums[0];
  for (let i = 1; i < nums.length; i++) {
    dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
    res = Math.max(dp[i], res);
  }
  return res;
};
// @lc code=end
console.log(maxSubArray([-2, 1, -3, 4, -4, 2, 5, -5, 20]));
