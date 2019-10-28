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
    let arr = []
    function helper(root, arr, level){
        if(root === null) {
            return 
        }
        if(arr[level] === undefined) {
            arr[level] = []
        }
        arr[level].push(root.val)
        if(root.children && root.children.length > 0) {
            for(let item of root.children) {
                helper(item, arr, level + 1)
            }
        }

    }
    helper(root, arr, 0)
    return arr
};
// @lc code=end

