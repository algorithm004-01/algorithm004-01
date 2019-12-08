package com.mrglint.leetcode.week02.solution104;

import com.mrglint.leetcode.TreeNode;

import java.util.Objects;

/**
 * @author luhuancheng
 * @since 2019-10-27 13:35
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        return Math.max(maxDepth(root.left, 1), maxDepth(root.right, 1));
    }

    private int maxDepth(TreeNode node, int level) {
        if (Objects.isNull(node)) {
            return level;
        }
        return Math.max(maxDepth(node.left, level + 1), maxDepth(node.right, level + 1));
    }
}

