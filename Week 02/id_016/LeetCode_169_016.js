/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-10-26 23:01:57
 * @LastEditTime: 2019-10-26 23:13:37
 */
/*
 * @lc app=leetcode id=169 lang=javascript
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (54.39%)
 * Likes:    2065
 * Dislikes: 181
 * Total Accepted:    452.2K
 * Total Submissions: 828.6K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 *
 * Example 1:
 *
 *
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 1. 迭代hash求解
 2.
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  if (nums.length === 1) return nums[0];
  let maxL = nums.length / 2;
  let map = {};
  let res;
  for (let i = 0; i < nums.length; i++) {
    if (map[nums[i]]) {
      map[nums[i]]++;
      if (map[nums[i]] > maxL) res = nums[i];
    } else {
      map[nums[i]] = 1;
    }
  }
  return res;
};
// @lc code=end

console.log(majorityElement([2, 2, 1, 1, 1, 2, 2]));
