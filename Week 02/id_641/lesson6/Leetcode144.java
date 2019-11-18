package vip.ruoyun.week2.lesson6;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 给定一个二叉树，返回它的 前序 遍历。
 */
public class Leetcode144 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //遍历
        handle(root, res);
        return res;
    }

    private void handle(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                handle(root.left, res);
            }
            if (root.right != null) {
                handle(root.right, res);
            }
        }
    }


}
