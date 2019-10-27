import java.util.*;
/**
 * 二叉树的中序遍历
 */
public class Solution {
    /**
     * 中序遍历
     * 基于递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root.left != null)
            list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        if (root.right != null)
            list.addAll(inorderTraversal(root.right));
        return list;
    }

    /**
     * 中序遍历
     * 基于栈
     * 每次讲遍历的节点的所有左节点入栈
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            TreeNode curr = root;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            root = curr.right;
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