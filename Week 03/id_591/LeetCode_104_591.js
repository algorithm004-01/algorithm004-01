/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    var result = {};
    
    var levelOrderRecursion = function(root, level){
        if(!root){
            return;
        }
    
        if(!result[level]){
            result[level] = [];
        }
        result[level].push(root.val);
        
        levelOrderRecursion(root.left, level+1);
        levelOrderRecursion(root.right, level+1);
    }
    
    levelOrderRecursion(root, 0);
    return Object.values(result);
};
