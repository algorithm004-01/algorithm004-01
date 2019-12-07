/**
 * [94. 二叉树的中序遍历 - 力扣（LeetCode）](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/)
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]} 
 中序排序 先拍左子树 再排根节点 最后 右子树
 */

var inorderTraversal = function(root) {
    const result = [];
    function pushRoot(root){ 
        if(root) {
          // 以前写的判断 root.left 为真 才执行加入，发现很耗性能
         root.left !== null && pushRoot(root.left)
         result.push(root.val);
         root.right !== null && pushRoot(root.right)
        }
     }
    pushRoot(root)
    
    return result;
};

// 基于栈的遍历

var inorderTraversal = function(root){
  var result = [];
  var tmpStack = [];
  var currNode = root;
  
  while(currNode!=null || tmpStack.length!=0) {
      while(currNode != null) {
          tmpStack.push(currNode);
          currNode = currNode.left;
      }
      currNode = tmpStack.pop();
      result.push(currNode.val);
      currNode = currNode.right;
  }
  
  return result;
}