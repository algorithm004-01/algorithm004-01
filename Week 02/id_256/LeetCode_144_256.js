/*
 * @lc app=leetcode.cn id=144 lang=javascript
 *
 * [144] 二叉树的前序遍历
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
var preorderTraversal = function(root) {
    let result = [];
    function pushRoot(root1) {
        if (!root1) return [];
        result.push(root1.val);
        if(root1.left) {
            pushRoot(root1.left);
        }
        if(root1.right) {
            pushRoot(root1.right);
        }
    }
    pushRoot(root);
    return result;
};
// @lc code=end

