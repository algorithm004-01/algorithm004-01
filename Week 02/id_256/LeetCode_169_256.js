/*
 * @lc app=leetcode.cn id=169 lang=javascript
 *
 * [169] 求众数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  // 暴力
  // let num_map = {};
  // for (let i = 0; i < nums.length; i++) {
  //     if(num_map[nums[i]] == undefined) {
  //         num_map[nums[i]] = 0;
  //     }
  //     num_map[nums[i]]++;
  //     if(num_map[nums[i]] > nums.length / 2) {
  //         return nums[i];
  //     }
  // }
  // 排序
  // nums.sort();
  // return nums[Math.floor(nums.length/2)]
  // Boyer-Moore 投票算法
  let candidate = -1;
  let count = 0;
  for (let key in nums) {
    if (count == 0) {
      candidate = nums[key];
    }
    count += candidate == nums[key] ? 1 : -1;
  }
  return candidate;
};
// @lc code=end
