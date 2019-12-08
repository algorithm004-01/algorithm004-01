import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
// 二叉树的层次遍历 II
// https://leetcode.com/problems/binary-tree-level-order-traversal/discuss/114449/A-general-approach-to-level-order-traversal-questions-in-Java

public class LeetCode_107_716 {
    // 1. 递归解法
    // 此题和 102 类似
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        levelOrderBottomHelper(root, 0, res);
        return res;
    }

    private void levelOrderBottomHelper(TreeNode node, int level, List<List<Integer>> res) {
        // terminator
        if (node == null) return;

        // process current logic
        if (res.size() < level + 1) {
            res.add(0, new ArrayList<>());
        }
        res.get(res.size() - level - 1).add(node.val);

        // drill down
        levelOrderBottomHelper(node.left, level + 1, res);
        levelOrderBottomHelper(node.right, level + 1, res);
    }

    // 2. 迭代 + 队列
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            res.add(0, new ArrayList<>());

            int levelNodeSize = queue.size();
            for (int i = 0; i < levelNodeSize; i++) {
                TreeNode curr = queue.poll();
                res.get(0).add(curr.val);

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}