/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
  helper(root);
  return root;
};

var helper = function(node) {
  //   terminate
  if (!node) return;
  //   process
  [node.left, node.right] = [node.right, node.left];
  //   drill down
  if (node.left) helper(node.left);
  if (node.right) helper(node.right);
  //   reverse state
};
