/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
  let result = [];
  let stack = [];
  let cur = root;
  while (cur || stack.length !== 0) {
    if (cur) {
      stack.push(cur);
      cur = cur.left;
    } else {
      cur = stack.pop();
      result.push(cur.val);
      cur = cur.right;
    }
  }
  return result;
};

var inorderTraversal = function(root) {
  let result = [];
  helper(root, result);
  return result;
};

var helper = function(node, memo) {
  if (!node) return;
  if (node.left) helper(node.left, memo);
  memo.push(node.val);
  if (node.right) helper(node.right, memo);
};