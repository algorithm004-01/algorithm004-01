/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-10-26 22:00:22
 * @LastEditTime: 2019-10-26 22:43:32
 */
/*
 * @lc app=leetcode id=50 lang=javascript
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (28.64%)
 * Likes:    1007
 * Dislikes: 2425
 * Total Accepted:    371.8K
 * Total Submissions: 1.3M
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 *
 * Example 1:
 *
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 *
 * Example 2:
 *
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 *
 * Example 3:
 *
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 *
 *
 * Note:
 *
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 *
 *

 1. 暴力法 时间O(n)
 2. 快速幂 时间O(logn)
 */

// @lc code=start
/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
  if (x === 0) return null;
  if (n === 0) return 1;
  let res = 1.0;
  for (let i = 0; i < Math.abs(n); i++) {
    res *= x;
  }
  return n > 0 ? res : 1 / res;
};
// var myPow = function(x, n) {
//   if (x === 0) return null;
//   if (n === 0) return 1;
//   let res = 1.0;

//   let deal = n => {
//     if (n === 0) return 1;
//     if (n === 1) return x;
//     if (n === 2) return x * x;
//     let temp = deal(parseInt(n / 2));
//     return temp * temp * (n % 2 ? x : 1);
//   };
//   res = deal(Math.abs(n));
//   return n > 0 ? res : 1 / res;
// };
// @lc code=end

console.log(myPow(2, 3));
// console.log(myPow(0.00001, 2147483647));
