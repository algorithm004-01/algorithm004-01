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
var postorder = function(root) {
  let result = [];
  if (!root) return result;
  let stack = [];
  stack.push(root);
  while (stack.length > 0) {
    let node = stack.pop();
    result.push(node.val);
    let length = node.children.length;
    for (let i = 0; i < length; i++) {
      stack.push(node.children[i]);
    }
  }
  return result.reverse();
};
