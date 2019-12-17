/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-11-17 20:16:19
 * @LastEditTime: 2019-11-17 20:25:28
 */
/*
 * @lc app=leetcode id=120 lang=javascript
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (40.98%)
 * Likes:    1412
 * Dislikes: 164
 * Total Accepted:    208.5K
 * Total Submissions: 504.3K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 *
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 *
 *
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 *
 */

// @lc code=start
/**
递推方程
1.重复性               problem(i,j) = min(sub(i,j),sub(i+1,j+1))+cur[i][j]
2.定义状态数组或者存贮   f[i][j]
3.DP方程              dep[i][j] = Math.min(dep[i + 1][j], dep[i + 1][j + 1]) + dep[i][j];
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {
  let dep = triangle;
  for (let i = dep.length - 2; i >= 0; i--) {
    for (let j = 0; j < dep[i].length; j++) {
      dep[i][j] = Math.min(dep[i + 1][j], dep[i + 1][j + 1]) + dep[i][j];
    }
  }
  return dep[0][0]
};
// @lc code=end
console.log(minimumTotal([[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]));