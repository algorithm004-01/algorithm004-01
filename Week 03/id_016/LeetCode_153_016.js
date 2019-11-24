/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-10-30 22:23:09
 * @LastEditTime: 2019-10-31 23:18:23
 */
/*
 * @lc app=leetcode id=153 lang=javascript
 *
 * [153] Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (43.67%)
 * Likes:    1313
 * Dislikes: 187
 * Total Accepted:    336.2K
 * Total Submissions: 767.9K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * 
 * 
  1.全部暴力, 查找最小值
  2.暴力循环 找无序 时间O(n)
  3.二分法   时间O(logn))
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
// var findMin = function(nums) {
//   let res = nums[0];
//   for (let i = 0; i < nums.length - 1; i++) {
//     if (nums[i] > nums[i + 1]) {
//       res = nums[i + 1];
//       break;
//     }
//   }
//   return res;
// };

var findMin = function(nums) {
  if (nums[0] < nums[nums.length - 1]) return nums[0];
  let right = nums.length - 1;
  let left = 0;
  while (left < right) {
    let mid = left + Math.floor((right - left) / 2);
    if (nums[mid] > nums[right]) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }
  return nums[left];
};
// @lc code=end
console.log(findMin([3, 1, 2]));
