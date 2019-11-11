package com.mrglint.leetcode.week03.solution515;

import com.mrglint.leetcode.TreeNode;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2019-10-31 22:11
 */
public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode queueHead = queue.poll();
                if (Objects.nonNull(queueHead)) {
                    max = Math.max(max, queueHead.val);
                    if (Objects.nonNull(queueHead.left)) {
                        queue.offer(queueHead.left);
                    }
                    if (Objects.nonNull(queueHead.right)) {
                        queue.offer(queueHead.right);
                    }
                }
            }
            result.add(max);
        }
        return result;
    }
}

