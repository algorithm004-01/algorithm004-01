package com.sslz.leetcode;


import org.apache.catalina.LifecycleState;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

public class leetcode_94 {

    /**
     * 关于二叉树的前  中  后 遍历的问题
     * 前序遍历： 根-左-右 ，根-右-左
     * 中序遍历： 左-根-右，右-根-左
     * 后序遍历：  左-右-根，右-左-根
     * 实则是根结点的遍历顺序，其次，有这些遍历顺序 是为了 能够完全的遍历到每一个节点
     * @param root
     * @param res
     */
    /**
     *
     * @param root
     * @param res
     */
    public void InOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                InOrder(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                InOrder(root.right, res);
            }
        }
    }
    public void postOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                postOrder(root.left, res);
            }
            if (root.right != null) {
                postOrder(root.right, res);
            }
            res.add(root.val);
        }
    }
    public void PreOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.val > 0) {
                res.add(root.val);
            }
            if (root.left != null) {
                PreOrder(root.left, res);
            }
            if (root.right != null) {
                PreOrder(root.right, res);
            }
        }
    }
}