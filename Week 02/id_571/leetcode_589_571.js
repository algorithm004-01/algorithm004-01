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
  let result = [];
  helper(root, result);
  return result;
};

var helper = function(node, memo) {
  if (!node) return;
  memo.push(node.val);
  for (let child of node.children) {
    helper(child, memo);
  }
};

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
  let result = [];
  if (!root) return result;
  let stack = [];
  stack.push(root);
  while (stack.length > 0) {
    let node = stack.pop();
    result.push(node.val);
    let length = node.children.length;
    for (let i = length - 1; i >= 0; i--) {
      stack.push(node.children[i]);
    }
  }
  return result;
};