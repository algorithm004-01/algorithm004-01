package com.mrglint.leetcode.week02.solution98;

import com.mrglint.leetcode.TreeNode;

import java.util.Objects;

/**
 * @author luhuancheng
 * @since 2019-10-27 10:51
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * @param node
     * @param lower 最小值，对于右子树而言，所有节点都不能小于lower
     * @param upper 最大值，对于左子树而言，所有节点都不能大于upper
     * @return
     */
    private boolean isValidBST(TreeNode node, TreeNode lower, TreeNode upper) {
        // 空节点视为一个合格的二分搜索树
        if (node == null) {
            return true;
        }

        // 如果存在最小值，那么当前节点不能小于最小值
        if (Objects.nonNull(lower) && node.val <= lower.val) {
            return false;
        }
        // 如果存在最大值，那么当前节点不能大于最大值
        if (Objects.nonNull(upper) && node.val >= upper.val) {
            return false;
        }
        // 比较左孩子，而且递归以左孩子为根的左子树，每次修改upper值
        if (!isValidBST(node.left, lower, node)) {
            return false;
        }
        // 比较右孩子，而且递归以右孩子为根的右子树，每次修改lower值
        if (!isValidBST(node.right, node, upper)) {
            return false;
        }
        return true;
    }
}

