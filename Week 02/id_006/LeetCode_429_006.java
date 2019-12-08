package com.mrglint.leetcode.week02.solution429;

import com.mrglint.leetcode.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author luhuancheng
 * @since 2019-10-26 21:07
 */
public class Solution {

    /**
     * 使用队列迭代
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> subResult = new ArrayList<>();
            int levelCount = queue.size();
            while (levelCount-- > 0) {
                Node queueHead = queue.poll();
                if (Objects.nonNull(queueHead)) {
                    subResult.add(queueHead.val);
                    if (Objects.nonNull(queueHead.children)) {
                        for (Node e : queueHead.children) {
                            queue.offer(e);
                        }
                    }
                }
            }
            result.add(subResult);
        }
        return result;
    }

    /**
     * 使用递归
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, 0, result);
        return result;
    }
    private void levelOrder(Node node, int depth, List<List<Integer>> result) {
        if (Objects.isNull(node)) {
            return;
        }
        // 为每一层建立结果集
        if (depth + 1 > result.size()) {
            result.add(depth, new ArrayList<>());
        }
        // 将当前层的放入当前层的结果集中
        result.get(depth).add(node.val);
        // 递归处理下一层
        for (Node item : node.children) {
            if (Objects.nonNull(item)) {
                levelOrder(item, depth + 1, result);
            }
        }
    }

}

