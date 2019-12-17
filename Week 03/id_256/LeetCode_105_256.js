/*
 * @lc app=leetcode.cn id=105 lang=javascript
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
 * @param {number[]} preorder 前序遍历 根 左 右
 * @param {number[]} inorder  中序遍历 左 根 右
 * @return {TreeNode}
 */
var buildTree = function(preOrder, inOrder) {
    if (inOrder.length == 0 && preOrder.length == 0) {
      return null;
    }
    let root = {};
    // 根据前序，中序规则，preOrder的第一个一定是根
    root.val = preOrder[0];
    let rootIdxInOrder = inOrder.indexOf(root.val);
    // 左子树的中序遍历 即根左边的列表
    let leftTreeInOrder = inOrder.slice(0, rootIdxInOrder);
    // 左子树的前序遍历 第一个是根跳过第一个，后续与 中序列表个数一致。
    let leftTreePreOrder = preOrder.slice(1, leftTreeInOrder.length + 1);
    root.left = buildTree(leftTreePreOrder, leftTreeInOrder);
    // 右子树的中序遍历 
    let rightTreeInOrder = inOrder.slice(rootIdxInOrder + 1);
    let rightTreePreOrder = preOrder.slice(rootIdxInOrder + 1);
    root.right = buildTree(rightTreePreOrder, rightTreeInOrder);
    console.log(root);
    return root;
  }
  // @lc code=end
  