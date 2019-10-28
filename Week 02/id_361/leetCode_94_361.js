//94. Binary Tree Inorder Traversal


/**
 *  * javascript
 * 1.递归
 * 时间复杂度：O(n)
 * 空间复杂度：最坏情况下需要空间O(n)O(n)，平均情况为O(\log n)O(logn)。
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
    var res=[]
    helper(root,res)
    return res
};

function helper(root,res){
    if (root != null) {
        if (root.left != null) {
            helper(root.left, res);
        }
        res.push(root.val);
        if (root.right != null) {
            helper(root.right, res);
        }
    }
}

/**
 * javascript
 * 2.基于栈的遍历
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
    let res = []
    let  stack = []
    let curr=root
    while (curr != null || stack.length>0) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        res.push(curr.val);
        curr = curr.right;
    }
    return res;
};



