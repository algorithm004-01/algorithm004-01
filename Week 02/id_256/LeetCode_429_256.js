/*
 * @lc app=leetcode.cn id=429 lang=javascript
 *
 * [429] N叉树的层序遍历
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
 * @return {number[][]}
 */
var levelOrder = function(root) {
    let nums = [];
    search(nums, root, 0);
    return nums;
};
function search(nums, node, k) {
    if(!node) {
        return;
    }
    if (nums[k] == undefined) {
        nums[k] = [];
    }
    nums[k].push(node.val);
    for (let i = 0; i < node.children.length; i++) {
        search(nums, node.children[i], k+1);
    }
}
// @lc code=end

