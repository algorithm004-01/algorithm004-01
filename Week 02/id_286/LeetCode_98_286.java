package com.uanei;

public class LeetCode_98_286 {

    /**
     * 递归：节点的值和上界或下界进行比较
     */
    public boolean isValidBST1(TreeNode root) {
        return compute(root, null, null);
    }

    private boolean compute(TreeNode node, Integer lower, Integer upper) {
        // 终结条件
        if (node == null) return true;

        int val = node.val;
        // 小于等于下界，错误
        if (lower != null && val <= lower) return false;
        // 大于等于上界，错误
        if (upper != null && val >= upper) return false;

        // 左子树中的上界就是当前节点，
        if (!compute(node.left, lower, val)) return false;
        // 右子树中的下界就是当前节点
        if (!compute(node.right, val, upper)) return false;

        return true;
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
