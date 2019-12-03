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
    let arr = [];
    function helper(root) {
        if(root !== null) {
            if(root.left !== null) {
                helper(root.left, arr)
            }
            arr.push(root.val)
            if(root.right !== null) {
                helper(root.right, arr)
            }
        }
    }
    helper(root)
    return arr
};
// @lc code=end

