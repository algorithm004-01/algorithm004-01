package com.mrglint.leetcode.week02.solution111;

import com.mrglint.leetcode.TreeNode;

import java.util.Objects;

/**
 * @author luhuancheng
 * @since 2019-10-27 13:45
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepth(root, 1);
    }

    private int minDepth(TreeNode node, int level) {
        if (Objects.isNull(node)) {
            return level;
        }
        if (Objects.isNull(node.left)) {
            return minDepth(node.right) + level;
        }
        if (Objects.isNull(node.right)) {
            return minDepth(node.left) + level;
        }
        return Math.min(minDepth(node.left, level + 1), minDepth(node.right, level + 1));
    }
}

