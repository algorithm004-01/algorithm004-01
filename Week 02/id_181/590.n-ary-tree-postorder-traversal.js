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

// 后序遍历 根 左 右
var postorder = function(root) {
  const result = [];
  function pushRoot(root) {
      if(root.val===null) return result;    
      if(root.children.length>0) {
         for(var i = 0; i<root.children.length;i++) {
             pushRoot(root.children[i]);
         }
      }
      result.push(root.val)
  }
  root && pushRoot(root);
  return result;
};