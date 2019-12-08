/*
 * @lc app=leetcode id=70 lang=javascript
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (45.24%)
 * Likes:    2886
 * Dislikes: 98
 * Total Accepted:    509.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '2'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 *
 * Example 2:
 *
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 */

// @lc code=start
/**
1.斐波那契式的傻递归 时间复杂度是O(2^n) 空间复杂度O(1)
2.递归增加缓存      时间复杂度是O(2^n) 空间复杂度O(n)
3.迭代法           时间复杂度是O(n)   空间复杂度O(1)
4.动态规划         时间复杂度是O(n)   空间复杂度O(n)
 * @param {number} n
 * @return {number}
 */
// var climbStairs = function(n) {
//   if (n === 1) return 1;
//   if (n === 2) return 2;
//   return climbStairs(n - 1) + climbStairs(n - 2);
// };
// var climbStairs = function(n) {
//   let cache = new Array(n).fill(1);
//   let deal = n => {
//     if (n === 1) return 1;
//     if (n === 2) return 2;
//     if (cache[n - 1] === 1) {
//       cache[n - 1] = deal(n - 1) + deal(n - 2);
//     }
//     return cache[n - 1];
//   };
//   return deal(n);
// };
// var climbStairs = function(n) {
//   if (n === 1) return 1;
//   if (n === 2) return 2;
//   let x = 1;
//   let y = 2;
//   let res = 0;
//   for (let i = 3; i <= n; i++) {
//     res = x + y;
//     x = y;
//     y = res;
//   }
//   return res
// };
/**
  1.最优子结构   opt[n] = opt[n-1] + opt[n-2]
  2.存储中间状态 opt[i]
  3.DP方程      opt[n] = opt[n-1] + opt[n-2]
 */
var climbStairs = function(n) {
  if (n === 1) return 1;
  if (n === 2) return 2;
  let dep = [];
  dep[0] = 1;
  dep[1] = 2;
  for (let i = 2; i < n; i++) {
    dep[i] = dep[i - 1] + dep[i - 2];
  }
  return dep[n - 1];
};
// @lc code=end

console.log(climbStairs(5));
