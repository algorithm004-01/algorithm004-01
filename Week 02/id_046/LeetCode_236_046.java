/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // 国际站学习到的解法，极其简洁的代码
    // 左子树和右子树递归到包含目标节点为止，依次往回返回结果
    // 直至左右子树均有返回值所得到的节点为最近公公祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root.val == p.val || root.val == q.val) return root;
        
        TreeNode lNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rNode = lowestCommonAncestor(root.right, p, q);
        return lNode == null ? rNode: rNode == null ? lNode: root;
    }
}