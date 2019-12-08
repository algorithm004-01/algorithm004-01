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
        if(root == null){  
            return true;
        }
        if(pushRoot(root.left)){
            result.push(root.val);
            return pushRoot(root.right)
        }
    }
    pushRoot(root)
    return result;
};

