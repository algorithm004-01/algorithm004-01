/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-10-30 22:00:00
 * @LastEditTime: 2019-10-30 22:00:36
 */
/*
 * @lc app=leetcode id=55 lang=javascript
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (32.67%)
 * Likes:    2544
 * Dislikes: 241
 * Total Accepted:    321.1K
 * Total Submissions: 980.4K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 *
 * Each element in the array represents your maximum jump length at that
 * position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 *
 *
 * Example 2:
 *
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 *
 *

  1. 贪心算法,从后往前贪心
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
  let last = nums.length - 1;
  for (let i = last - 1; i >= 0; i--) {
    if (nums[i] + i >= last) {
      last = i;
    }
  }
  return last === 0;
};
// @lc code=end
