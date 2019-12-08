import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
// 在每个树行中找最大值

public class LeetCode_515_716 {
    // 1. bfs
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.val > max) max = curr.val;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            res.add(max);
        }
        return res;
    }

    // 2. dfs
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<Integer> res) {
        if (node == null) return;

        if (res.size() < level + 1) {
            res.add(Integer.MIN_VALUE);
        }
        if (node.val > res.get(level)) res.set(level, node.val);

        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}