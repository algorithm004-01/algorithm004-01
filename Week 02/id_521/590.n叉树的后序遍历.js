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
    let arr = []
    function helper(root, arr) {
        if(root !== null) {
            if(root.children && root.children.length > 0) {
                for(let item of root.children) {
                    helper(item, arr)
                }
            }
            arr.push(root.val)
        }
    }
    helper(root, arr)
    return arr
};
// @lc code=end

