package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author alis
 * @date 2019/10/27 12:55 AM
 * @description
 */
public class LeetCode_144_721 {


    /**
     * 二叉树前序遍历：根 左 右
     * 递归
     */
    public List<Integer> preOrderTraversalRecur(tree.TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        // terminator
        if (null == root) return nums;

        // process
        nums.add(root.val);

        // drill down
        if (root.left != null) nums.addAll(preOrderTraversalRecur(root.left));
        if (root.right != null) nums.addAll(preOrderTraversalRecur(root.right));

        // reverse states

        return nums;
    }

    /**
     * 栈迭代 前序遍历二叉树
     * 核心思想：先将根结点入栈，在while循环中取出，如果子结点不为空，先入栈右结点，再入栈左结点，
     * 继续while循环，输出根结点的值
     */
    public List<Integer> preOrderTraversalStack(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        if (null == root) return nums;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            nums.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
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
