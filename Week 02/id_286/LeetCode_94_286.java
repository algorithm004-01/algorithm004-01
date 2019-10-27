package com.uanei;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_94_286 {

    /**
     * 递归求解
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        compute(root, res);
        return res;
    }

    private void compute(TreeNode root, List<Integer> res) {
        // 判断节点是否存在
        if (root != null) {
            // 左子树继续递归
            if (root.left != null) {
                compute(root.left, res);
            }

            // 没有左子树了，保存当前节点元素
            res.add(root.val);

            // 右节点继续递归
            if (root.right != null) {
                compute(root.right, res);
            }
        }
    }

    /**
     * 二叉树节点类
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
