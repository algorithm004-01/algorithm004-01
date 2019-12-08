import java.util.*;
/**
 * 二叉树的前序遍历
 */
public class Solution {
    /**
     * 前序遍历
     * 基于递归
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.left != null)
            list.addAll(preorderTraversal(root.left));
        if (root.right != null)
            list.addAll(preorderTraversal(root.right));
        return list;
    }

    /**
     * 前序遍历
     * 基于栈
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            while (curr != null) {
                list.add(curr.val);
                if (curr.right != null)
                    stack.push(curr.right);
                if (curr.left != null) {
                    curr = curr.left;
                } else break;
            }
        }
        return list;
    }

    /**
     * 前序遍历
     * 基于栈优化版
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(curr.val);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return list;
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