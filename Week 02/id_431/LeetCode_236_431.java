package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘磊明
 * @date 2019/10/25
 */
public class LowestCommonAncestorOfABinaryTree {
    private TreeNode result;

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        reserval(root, p, q);
//        return  result;
//    }

    /**
     * 精妙解法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    private boolean reserval(TreeNode node, TreeNode p, TreeNode q){
        if (node == null) return false;
        int left = reserval(node.left, p, q) ? 1 : 0;
        int right = reserval(node.right, p, q) ? 1 : 0;
        int current = node.val == p.val || node.val == q.val ? 1 : 0;
        if (left + right + current >= 2) {
            result = node;
        }
        return left + right + current > 0;
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
}
