/*
 * @lc app=leetcode.cn id=236 lang=javascript
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    this.node = null;
    recursionTree(root, q, p);
    return this.node;
  };
  let recursionTree = function(node, p, q) {
    if (!node) return false;
    let left = recursionTree(node.left, p, q) ? 1 : 0;
    let right = recursionTree(node.right, p, q) ? 1 : 0;
    let mid = (node == p || node == q) ? 1 : 0;
    if (left + right + mid >= 2) {
      this.node = node;
    }
    return (left + right + mid > 0);
  };
  // @lc code=end
  