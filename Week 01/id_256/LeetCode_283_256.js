/*
 * @lc app=leetcode.cn id=283 lang=javascript
 *
 * [283] 移动零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    // 方法一
    // let pos = 0;
    // for (let i = 0; i < nums.length; i++) {
    //     if (nums[i] != 0) {
    //         nums[pos++] = nums[i];
    //     }
    // }
    // while( pos < nums.length) {
    //     nums[pos++] = 0;
    // }
    //
    //方法二
    let pos = 0;
    for (let i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        if (i != pos) {
          nums[pos] = nums[i];
          nums[i] = 0;
        }
        pos++;
      }
    }
  };
  // @lc code=end
  