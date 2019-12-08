/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-10-31 08:54:26
 * @LastEditTime: 2019-10-31 08:55:22
 */
/*
 * @lc app=leetcode id=69 lang=javascript
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (32.22%)
 * Likes:    932
 * Dislikes: 1568
 * Total Accepted:    434.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '4'
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 *
 * Example 1:
 *
 *
 * Input: 4
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 *
 *
 1. 二分法解决,边界情况考虑
 2. 牛顿迭代
 */

// @lc code=start
/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
  if (x === 0 || x === 1) return x;
  let left = 0,
    right = x;
  let mid = null;
  while (left <= right) {
    mid = Math.ceil((left + right) / 2);
    if (mid * mid == x) return mid;
    if (x < mid * mid) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  return Math.floor(right);
};
// @lc code=end
