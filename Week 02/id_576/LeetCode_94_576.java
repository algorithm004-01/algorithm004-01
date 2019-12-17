package id_576;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_94_576 {


    // Approach 1: recursion, O(n)
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) helper(root.left, res);
            res.add(root.val);
            if (root.right != null) helper(root.right, res);
        }
    }

    // Approach 2: create a stack with manual, O(n)
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }


}
