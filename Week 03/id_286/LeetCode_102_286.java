package com.uanei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_102_286 {

    /**
     * dfs 深度优先：递归
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;
        else compute(root, 0, res);
        return res;
    }

    private void compute(TreeNode node, int level, List<List<Integer>> res) {
        // level 从0开始，即根节点开始
        // 初始化 level + 1 层，即当前层的集合
        // 如果不想等，说明集合已经初始化了
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }

        // 将当前节点添加到当前层的集合中
        res.get(level).add(node.val);

        // 继续处理子节点
        if (node.left != null) compute(node.left, level + 1, res);
        if (node.right != null) compute(node.right, level + 1, res);
    }

    /**
     * bfs 广度优先，queue + while
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        // 队列中的节点是一层一层的
        while (!queue.isEmpty()) {
            // 初始化当前层集合
            res.add(new ArrayList<>());

            // 遍历当前层
            int currentLevelLength = queue.size();
            for (int i = 0; i < currentLevelLength; i++) {
                // 从队列中移除
                TreeNode node = queue.remove();

                // 添加到集合中
                res.get(level).add(node.val);

                // 将当前层节点的子节点添加到队列中
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // 下一层
            level++;
        }

        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
