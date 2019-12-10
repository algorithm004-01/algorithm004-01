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
    let arr = []
    function helper(root, arr) {
        if(root !== null){
            arr.push(root.val); // 处理本层逻辑
            if(root.left !== null) {
                helper(root.left, arr) // 进入下一层
            }
            if(root.right !== null) { // 进入下一层， 这里其实有点分治的意思，左右分别处理
                helper(root.right, arr)
            }
        } 
    }
    helper(root, arr)
    return arr
};
// @lc code=end

