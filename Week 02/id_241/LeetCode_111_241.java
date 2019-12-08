import java.util.*;
/**
 * 二叉树的最小深度
 */
public class Solution {
    /**
     * 二叉树的最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int depth = Integer.MAX_VALUE;
        if (root.left != null) {
            depth = minDepth(root.left);
        }
        if (root.right != null) {
            depth = Math.min(minDepth(root.right), depth);
        }
        return depth + 1;
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