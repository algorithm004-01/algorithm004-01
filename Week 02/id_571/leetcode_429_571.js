/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  let result = [];
  if (!root) return result;
  let queue = [];
  queue.push(root);
  while (queue.length > 0) {
    let data = [];
    let length = queue.length;
    for (let i = 0; i < length; i++) {
      let node = queue.shift();
      data.push(node.val);
      for (let child of node.children) {
        queue.push(child);
      }
    }
    result.push(data);
  }
  return result;
};
