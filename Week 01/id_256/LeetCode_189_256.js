/*
 * @lc app=leetcode.cn id=189 lang=javascript
 *
 * [189] 旋转数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
  // 暴力解
  // if(nums.length === 0 || nums.length === k) {
  //     return nums;
  // }
  // while (k > 0) {
  //     let previous = nums[nums.length - 1];
  //     for (let i = 0; i < nums.length; i++) {
  //         let temp = nums[i];
  //         nums[i] = previous;
  //         previous = temp;
  //     }
  //     k--;
  // }
  // return nums;

  // 绝起反转
  // let len = nums.length;
  // k = k % len;
  // if (k == len || len == 1 || len == 0) return nums;
  // nums = nums.splice(len - k, k).concat(nums);
  // return nums;

  // 分段截取
  let n = nums.length;
  k %= n;
  let tmp = 0;
  if (n == 1 || k == n) return;
  myRevese(0, n - 1);
  myRevese(0, k - 1);
  myRevese(k, n - 1);
  function myRevese(start, end) {
    while (start < end) {
      tmp = nums[start];
      nums[start] = nums[end];
      nums[end] = tmp;
      start++;
      end--;
    }
  }
};
// @lc code=end
