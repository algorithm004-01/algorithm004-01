import java.util.*;
/**
 * 二叉树的最近公共祖先
 */
public class Solution {
    /**
     * 二叉树的最近公共祖先(13ms)
     */
    TreeNode common = new TreeNode(0);

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int left = lowestCommonAncestor(root.left, p, q) == null ? 0 : 1;
        int right = lowestCommonAncestor(root.right, p, q) == null ? 0 : 1;
        int middle = 0;
        if (root.val == p.val || root.val == q.val)
            middle = 1;
        if (left + right + middle >= 2)
            common = root;
        return (left + right + middle > 0) ? common : null;
    }

    /**
     * 二叉树的最近公共祖先(改进版 9ms)
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //如果找到等于 p 或 q，直接返回不在继续对当前方向子树进行递归。直接递归另一边的子树即可
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        //达到叶子节点
        if (left == null && right == null)
            return null;
        //最外层，如果一边不为空，一边为空，说明要查询的节点均在一边，则返回此边的节点即为公共祖先
        if (left == null || right == null)
            return left == null ? right : left;
        //如果两遍皆不为空，则当前的根节点即为公共祖先
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}