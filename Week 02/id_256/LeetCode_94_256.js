/*
 * @lc app=leetcode.cn id=94 lang=javascript
 *
 * [94] 二叉树的中序遍历
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
 * @return {number[]}
 */
var inorderTraversal = function(root) {
  var result = [];
  if (!root) return [];
  function pushRoot(root1) {
    if (root1.left) {
      pushRoot(root1.left);
    }
    result.push(root1.val);
    if (root1.right) {
      pushRoot(root1.right);
    }
  }
  pushRoot(root);
  return result;
  //国外方法 递归
  //   if (!root) return [];
  //   return [
  //     ...inorderTraversal(root.left),
  //     root.val,
  //     ...inorderTraversal(root.right)
  //   ];
  //国外方法 迭代 个人觉得不便于理解
  // const traversed = [];

  // if (!root) {
  //   return traversed;
  // }

  // const nodes = [root];
  // let currentNode = root.left;

  // while (currentNode || nodes.length) {
  //   while (currentNode) {
  //     nodes.push(currentNode);
  //     currentNode = currentNode.left;
  //   }

  //   currentNode = nodes.pop();
  //   traversed.push(currentNode.val);
  //   currentNode = currentNode.right;
  // }

  // return traversed;
};
// @lc code=end
