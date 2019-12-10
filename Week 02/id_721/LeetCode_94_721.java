package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author alis
 * @date 2019/10/26 12:32 AM
 * @description
 */
public class LeetCode_94_721 {

    /**
     * 利用栈迭代式中序遍历二叉树：左 根 右
     * 利用栈先进后出的特性
     * 先把根目录下的左结点，入栈，直至到最左结点(第一个输出的结点)
     * 判断出栈输出条件：栈顶
     * 如果已出栈结点存在右子结点，则右子结点入栈，并结束本次内循环，
     * 将本右子结点的所有左子结点入栈，重复以上步骤进行迭代循环
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        if (null == root) return nums;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            while (stack.peek().left != null) {
                stack.push(stack.peek().left);
            }
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                nums.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                    break;
                }
            }
        }
        return nums;
    }

    /**
     * 递归遍历二叉树，中序遍历：左 根 🈶右
     */
    public List<Integer> inOrderTraversalReverse(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        if (nums == root) return nums;
        if (root.left != null) {
            nums.addAll(inOrderTraversalReverse(root.left));
        }
        nums.add(root.val);
        if (root.right != null) {
            nums.addAll(inOrderTraversalReverse(root.right));
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
