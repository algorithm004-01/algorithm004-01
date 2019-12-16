package id_576;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_144_576 {

    // Approach 1: recursion, O(n)
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    // Approach 2: stack with manual, O(n)
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop().right;
        }
        return res;
    }

}
