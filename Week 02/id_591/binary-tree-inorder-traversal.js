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
    let number = [];
    if(root == null){
        return number;
    }
        
    var inorder = function(binaryTree){
        if(binaryTree.left != null){
            inorder(binaryTree.left);
        }
        
        number.push(binaryTree.val);

        if(binaryTree.right != null){
            inorder(binaryTree.right);
        }
    }
    inorder(root);
    return number;
    
};
