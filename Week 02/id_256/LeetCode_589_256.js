/*
 * @lc app=leetcode.cn id=589 lang=javascript
 *
 * [589] N叉树的前序遍历
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
var preorder = function(root) {
    //方案一
    let results = [];
    if (!root) return [];
    function pushRoot(node) {
      results.push(node.val);
      for (let i = 0; i < node.children.length; i++) {
        pushRoot(node.children[i]);
      }
    }
    pushRoot(root);
    return results;
  
    //方案二
    // let results = [];
    // if(!root) return [];
    // function pushRoot(node) {
    //     results.push(node.val);
    //     for(let i = 0; i < node.children.length; i++) {
    //         if(node.children[i].children.length > 0) {
    //             pushRoot(node.children[i]);
    //         }else{
    //             results.push(node.children[i].val);
    //         }
    //     }
    // }
    // pushRoot(root);
    // return results;
  };
  // @lc code=end
  