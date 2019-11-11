import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode-cn.com/problems/binary-tree-level-order-traversal
// 二叉树的层次遍历

public class LeetCode_102_716 {
    // 1. 使用loop + 队列
    public List<List<Integer>> levelOrder1(TreeNode root) {
        // 存储结果
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        // 用队列来暂存依次要访问的每层节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 跟踪正在遍历的是第几层的节点
        int level = 0;
        while (!queue.isEmpty()) {
            // 初始化当前层的容器
            res.add(new ArrayList<>());

            // 获取队列的大小，表示要遍历的当前层的节点个数
            int nodeCntInCurrLevel = queue.size();
            for (int i = 0; i < nodeCntInCurrLevel; ++i) {
                TreeNode curr = queue.poll();
                res.get(level).add(curr.val);

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            // 当前层遍历完了之后，层数+1
            level++;
        }

        return res;
    }

    // 2. 使用递归
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderHelper(root, 0, res);
        return res;
    }

    // 可以使用递归解决，需要跟踪level
    // 重复性是：每次都是遍历当前节点，记录值（只需要跟踪层次即可），然后是左子树，然后是右子树
    private void levelOrderHelper(TreeNode node, int level, List<List<Integer>> res) {
        // terminator
        if (node == null) return;

        // process current logic
        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);

        // drill down
        levelOrderHelper(node.left, level + 1, res);
        levelOrderHelper(node.right, level + 1, res);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}
