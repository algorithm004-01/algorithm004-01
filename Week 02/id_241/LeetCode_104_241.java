import java.util.*;
/**
 * 二叉树的最大深度
 */
public class Solution {
    /**
     * 二叉树的最大深度
     * 基于递归(每次进入一层函数，就增加一个 level)
     */
    int maxLevel = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        maxDepthHelper(root, 1);
        return maxLevel;
    }

    private void maxDepthHelper(TreeNode root, int level) {
        if (root == null) return;
        maxDepthHelper(root.left, level + 1);
        maxDepthHelper(root.right, level + 1);
        maxLevel = Math.max(maxLevel, level);
    }

    /**
     * 二叉树的最大深度
     * 基于递归(改进版，完全利用递归的反向思维，每次回溯的时候，层级加 1 即可)
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        return Math.max(left, right) + 1;
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