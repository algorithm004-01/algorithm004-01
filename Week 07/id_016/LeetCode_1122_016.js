/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-12-01 18:18:14
 * @LastEditTime: 2019-12-01 18:18:27
 */
/*
 * @lc app=leetcode id=1122 lang=javascript
 *
 * [1122] Relative Sort Array
 *
 * https://leetcode.com/problems/relative-sort-array/description/
 *
 * algorithms
 * Easy (66.19%)
 * Likes:    301
 * Dislikes: 22
 * Total Accepted:    30.6K
 * Total Submissions: 46K
 * Testcase Example:  '[2,3,1,3,2,4,6,7,9,2,19]\n[2,1,4,3,9,6]'
 *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all
 * elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1
 * are the same as in arr2.  Elements that don't appear in arr2 should be
 * placed at the end of arr1 in ascending order.
 *
 *
 * Example 1:
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * Constraints:
 *
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 *
 *
 */

// @lc code=start
/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
  let res = [];
  arr2.map(item => {
    let index = arr1.indexOf(item);
    while (index > -1) {
      res.push(arr1.splice(index, 1));
      index = arr1.indexOf(item);
    }
  });
  return res.concat(arr1.sort((a, b) => a - b));
};
// @lc code=end
