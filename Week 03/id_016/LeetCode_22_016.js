/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-10-26 15:45:05
 * @LastEditTime: 2019-10-26 16:04:44
 */
/*
 * @lc app=leetcode id=22 lang=javascript
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (57.41%)
 * Likes:    3475
 * Dislikes: 206
 * Total Accepted:    411.4K
 * Total Submissions: 712.8K
 * Testcase Example:  '3'
 *
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 *
 *
 *
 * For example, given n = 3, a solution set is:
 *
 *
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 *
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
  let res = [];
  let deal = (left = n, right = n, str = '') => {
    if (str.length === n * 2) {
      res.push(str);
      return;
    }
    if (left > 0) deal(left - 1, right, str + '(');
    // 注意括号的规则就可以:放置右括号前必须保证左括号的数量多于右括号
    if (right > 0 && left < right) deal(left, right - 1, str + ')');
  };
  deal();
  return res;
};
// @lc code=end
console.log(generateParenthesis(3));
