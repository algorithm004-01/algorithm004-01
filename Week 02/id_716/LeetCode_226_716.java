import java.util.LinkedList;
import java.util.Queue;

// https://leetcode-cn.com/problems/invert-binary-tree/
// 翻转二叉树

public class LeetCode_226_716 {
    // 1. 递归求解
    // 1.1
    public TreeNode invertTree11(TreeNode root) {
        // terminator
        if (root == null) return null;

        // drill down:翻转左子树 & 翻转右子树
        TreeNode left = invertTree11(root.left);
        TreeNode right = invertTree11(root.right);

        // process current logic：左右互换
        root.left = right;
        root.right = left;

        return root;
    }

    // 1.2 换一种写法
    public TreeNode invertTree12(TreeNode root) {
        // terminator
        if (root == null) return null;

        // drill down & process current logic
        TreeNode temp = root.right;
        root.right = invertTree12(root.left);
        root.left = invertTree12(temp);

        return root;
    }

    // 2. 递归的实现很简洁，但是这里的递归调用没有办法用尾递归进行优化，所以随着调用栈的增加，内存使用量会递增，导致stack overflow
    // 所以说递归解法的鲁棒性在数据大时不好，可以考虑使用 loop + stack 的方式
    public TreeNode invertTree21(TreeNode root) {
        if (root == null) return null;

        final LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return root;
    }

    // 2.2 使用队列，使用 BFS 的方式做层次遍历
    public TreeNode invertTree22(TreeNode root) {
        if (root == null) return null;

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}