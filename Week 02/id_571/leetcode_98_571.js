/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
  return helper(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);
};

var helper = function(node, lower, upper) {
  //   terminator
  if (!node) return true;
  //   process current logic
  if (node.val <= lower || node.val >= upper) return false;
  //   drill down
  if (!helper(node.left, lower, node.val)) return false;
  if (!helper(node.right, node.val, upper)) return false;
  return true;
  //   reverse state
};
