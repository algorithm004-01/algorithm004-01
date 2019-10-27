// #### 解法一：递归
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
    function pushRoot(root){
        if(root != null){
            if(root.left != null){
                pushRoot(root.left);
            }
            result.push(root.val);
            if(root.right !=null){
                pushRoot(root.right);
            }
        }
    }
    pushRoot(root);
    return result;
};
// #### 解法二：基于栈的遍历
// + 时间复杂度：O(n)
// + 空间复杂度：O(n)

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
    var tmpStack = [];
    var currNode = root;
    while(currNode != null || tmpStack.length !=0){
        while(currNode != null){
            tmpStack.push(currNode);
            currNode = currNode.left;
        }
        currNode = tmpStack.pop();
        result.push(currNode.val);
        currNode = currNode.right;
    }
    return result;
};