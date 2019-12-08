package Week2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = preorderTraversal(root);
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * 简单递归
     * 执行用时 :1 ms, 在所有 java 提交中击败了97.16%的用户
     * 内存消耗 :34.6 MB, 在所有 java 提交中击败了41.71%的用户
     * @param root
     * @return
     */
    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        bl(list,root);
        return list;
    }

    private static void bl(List<Integer> list, TreeNode root) {
        if (root == null)
            return;
        list.add(root.val);
        bl(list,root.left);
        bl(list,root.right);
    }
}
