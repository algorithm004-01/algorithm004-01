package vip.ruoyun.week2.lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 给定一个二叉树，返回它的中序 遍历。
 */
public class Leetcode94 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //方法一:直接递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //遍历
        handle(root, res);
        return res;
    }

    private void handle(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                handle(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                handle(root.right, res);
            }
        }
    }


    //方法二:使用栈
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static void main(String[] args) {


    }
}
