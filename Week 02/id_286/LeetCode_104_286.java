package com.uanei;

public class LeetCode_104_286 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            // 计算左右子树的深度
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            // 比较左右子树深度，加上当前节点这一层
            return Math.max(left, right) + 1;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
