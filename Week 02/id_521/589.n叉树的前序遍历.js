/*
 * @lc app=leetcode.cn id=589 lang=javascript
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function(root) {
  let arr = [];
  function helper(root, arr, k) {
    if (root !== null) {
      arr.push(root.val);
      if (root.children && root.children.length > 0) {
        for (let item of root.children) {
          helper(item, arr);
        }
      }
    }
  }
  helper(root, arr);
  return arr;
};
// @lc code=end
