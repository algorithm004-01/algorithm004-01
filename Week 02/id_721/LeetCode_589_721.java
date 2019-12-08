package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author alis
 * @date 2019/10/27 8:43 AM
 * @description n叉树的前序遍历
 */
public class LeetCode_589_721 {
    /**
     * 递归遍历n叉树
     */
    public List<Integer> preOrderTraversalRecur(NTreeNode root) {
        List<Integer> nums = new ArrayList<>();
        if (root == null) {
            return nums;
        }
        nums.add(root.val);
        if (root.children != null && !root.children.isEmpty()) {
            for (NTreeNode child : root.children) {
                nums.addAll(preOrderTraversalRecur(child));
            }
        }
        return nums;
    }

    public List<Integer> preOrderTraversalStack(NTreeNode root) {
        List<Integer> nums = new ArrayList<>();
        if (root == null) {
            return nums;
        }
        Stack<NTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            NTreeNode node = stack.pop();
            nums.add(node.val);
            if (node.children != null && !node.children.isEmpty()) {
                Collections.reverse(node.children);
                node.children.forEach(stack::push);
            }
        }
        return nums;
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
