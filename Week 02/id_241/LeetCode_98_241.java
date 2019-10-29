import java.util.*;
/**
 * 验证二叉搜索树
 */
public class Solution {
    /**
     * 验证二叉搜索树
     * 基于递归
     */
    public isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBSTHelper(root, null, null);
    }

    private isValidBSTHelper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;
        if (lower != null && root.val <= lower) return false;
        if (upper != null && root.val >= upper) return false;
        if (!isValidBSTHelper(root.left, lower, root.val)) return false;
        return isValidBSTHelper(root.right, root.val, upper);
    }

    /**
     * 验证二叉搜索树
     * 基于中序遍历
     */
    Integer prev = null;

    public boolean isValidBST2(TreeNode root) {
        return isValidBST2Helper(root);
    }

    private boolean isValidBST2Helper(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && !isValidBST2Helper(root.left)) return false;
        if (prev != null && root.val <= prev) return false;
        prev = root.val;
        if (root.right != null) return isValidBST2Helper(root.right);
        return true;
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