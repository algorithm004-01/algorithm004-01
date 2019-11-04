/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-10-19 10:09:38
 * @LastEditTime: 2019-10-19 15:40:33
1.暴力破解 3层循环 O(n^3)         -- 存在执行时间过长的问题
2.模拟两数之和-双指针进行求解O(n^2) -- 代码过于冗余
3.参考网上代码进行修复O(n^2)       -- 修复了数组重复的问题,优化代码18行
 */
/*
 * @lc app=leetcode id=15 lang=javascript
 *
 * [15] 3Sum
 */
// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
// var threeSum = function(nums) {
//   let length = nums.length;
//   let arr = [];
//   let map = new Map();
//   for (let i = 0; i < length - 2; i++) {
//     for (let j = i + 1; j < length - 1; j++) {
//       for (let k = j + 1; k < length; k++) {
//         if (nums[i] + nums[j] + nums[k] === 0) {
//           arr.push([nums[i], nums[j], nums[k]]);
//         }
//       }
//     }
//   }
//   arr.forEach(item => {
//     item.sort((a, b) => a - b);
//     map.set(item.join(), item);
//   });
//   return Array.from(map.values());
// };
var threeSum = function(nums) {
  nums.sort((a, b) => a - b);
  let arr = [];
  for (let i = 0; i < nums.length - 2; i++) {
    if (i > 0 && nums[i] === nums[i - 1]) continue;
    for (let l = i + 1, r = nums.length - 1; l < r; ) {
      let sum = nums[i] + nums[l] + nums[r];
      if (sum === 0) {
        arr.push([nums[i], nums[l++], nums[r--]]);
        while (l < r && nums[l] === nums[l - 1]) l++;
        while (l < r && nums[r] === nums[r + 1]) r--;
      } else if (sum < 0) {
        l++;
      } else if (sum > 0) {
        r--;
      }
    }
  }
  return arr;
};
// @lc code=end
// console.log(threeSum([0, 0, 0, 0]));
console.log(threeSum([-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6]));
// console.log(threeSum([-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6]));
