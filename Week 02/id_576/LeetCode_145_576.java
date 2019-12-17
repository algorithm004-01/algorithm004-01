package id_576;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_145_576 {

    // Approach 1: recursion, O(n)
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

    // Approach 2: stack with manual, O(n)
    /**
     * 更为简洁的写法。这种解法的思想是先序遍历的变形，
     * 先序遍历是“根->左->右”，后序遍历是“左->右->根”，
     * 那么把先序遍历改成“根->右->左”，再逆序一下就是后序遍历。
     * 没太明白意思？再多练习几遍
     * 画一遍图有些理解了，等于是逆序，从后往前存值。
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }
}
