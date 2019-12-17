package vip.ruoyun.week2.lesson7;

import vip.ruoyun.week2.lesson6.Leetcode94;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class Leetcode236 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode ans;

    public boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }

        //递归node 的左节点
        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
        //递归 node 的右节点
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;
        //看看当前的节点的值
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }
}

