package com.mrglint.leetcode.week03.solution102;

import com.mrglint.leetcode.TreeNode;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2019-10-30 22:26
 */
public class Solution {
    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subResult = new ArrayList<>();
            while (size-- > 0) {
                TreeNode queueHead = queue.poll();
                if (Objects.nonNull(queueHead)) {
                    subResult.add(queueHead.val);
                    if (queueHead.left != null) {
                        queue.offer(queueHead.left);
                    }
                    if (queueHead.right != null) {
                        queue.offer(queueHead.right);
                    }
                }
            }
            result.add(subResult);
        }
        return result;
    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        levelOrder(root, 0, result);
        return result;
    }

    private void levelOrder(TreeNode node, int level, List<List<Integer>> result) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        if (Objects.nonNull(node.left)) {
            levelOrder(node.left, level + 1, result);
        }
        if (Objects.nonNull(node.right)) {
            levelOrder(node.right, level + 1, result);
        }
    }
}

