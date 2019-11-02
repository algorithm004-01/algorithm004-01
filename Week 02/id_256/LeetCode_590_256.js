/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
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
var postorder = function(root) {
  // 方案一
  let nums = [];
  function pushRoot(node) {
    if (node != null) {
      for (let i = 0; i < node.children.length; i++) {
        if (node.children[i].children.length > 0) {
          pushRoot(node.children[i]);
        } else {
          nums.push(node.children[i].val);
        }
      }
      nums.push(node.val);
    }
  }
  pushRoot(root);
  return nums;

  // 方案二
  //   let nums = [];
  //   function pushRoot(node) {
  //     if (node) {
  //       for (let i = 0; i < node.children.length; i++) {
  //         pushRoot(node.children[i]);
  //       }
  //       nums.push(node.val);
  //     }
  //   }
  //   pushRoot(root);
  //   return nums;
};
// @lc code=end
