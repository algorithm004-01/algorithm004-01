package Week2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Leetcode_94 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(2);
        t1.right.left = new TreeNode(3);
        List<Integer> list = inorderTraversal1(t1);
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * 迭代法，使用栈，参考题解
     * 执行用时 :1 ms, 在所有 java 提交中击败了97.03的用户
     * 内存消耗 :34.8 MB, 在所有 java 提交中击败了39.36%的用户
     * @param root
     * @return
     */

    private static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    /**
     * 简单递归
     * 执行用时 :1 ms, 在所有 java 提交中击败了97.03%的用户
     * 内存消耗 :34.7 MB, 在所有 java 提交中击败了39.90%的用户
     * @param root
     * @return
     */
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        bl(list,root);
        return list;
    }

    private static void bl(List<Integer> list, TreeNode root) {
        if (root == null)
            return;
        bl(list,root.left);
        list.add(root.val);
        bl(list,root.right);
    }
}
