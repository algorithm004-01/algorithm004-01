/*
 * @lc app=leetcode id=189 lang=javascript
 *
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (31.69%)
 * Likes:    1718
 * Dislikes: 670
 * Total Accepted:    357.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Note:
 * 
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
  1.队列一样出队入队                  -- 时间O(n) 空间O(1)
  2.一次性计算完成进行移动             -- 时间O(1) 空间O(n)
  3.预先计算好每个数的位置,一趟循环走完  -- 时间O(n) 空间O(n)
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// var rotate = function(nums, k) {
//     while (k) {
//       let res = nums.pop();
//       nums.unshift(res);
//       k--;
//     }
//     return nums;
// };
// var rotate = function(nums, k) {
//   let length = nums.length;
//   k = k % length;
//   let t = length - k;
//   let tempArr = nums.slice(t);
//   console.log(tempArr);
//   nums.splice(k, t, ...nums.slice(0, t));
//   nums.splice(0, k, ...tempArr);
//   return nums;
// };
var rotate = function(nums, k) {
  let temp = [...nums];
  let length = nums.length;
  for (let i = 0; i < length; i++) {
    nums[(i + k) % length] = temp[i];
  }
  return nums;
};
// @lc code=end
console.log(rotate([-1, -100, 3, 99], 2));
