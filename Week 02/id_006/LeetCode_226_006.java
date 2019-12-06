package com.mrglint.leetcode.week02.solution226;

import com.mrglint.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-10-27 10:16
 */
public class Solution {

    /**
     * 递归方式
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 翻转左子树后，返回左子树
        TreeNode left = invertTree1(root.left);
        // 翻转右子树后，返回右子树
        TreeNode right = invertTree1(root.right);
        // 将翻转后的子树，挂到根节点
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 迭代法，跟利用队列进行层序遍历的方式雷同。
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode queueHead = queue.poll();
            if (Objects.nonNull(queueHead)) {
                TreeNode left = queueHead.left;
                queueHead.left = queueHead.right;
                queueHead.right = left;
                if (Objects.nonNull(queueHead.left)) {
                    queue.offer(queueHead.left);
                }
                if (Objects.nonNull(queueHead.right)) {
                    queue.offer(queueHead.right);
                }
            }
        }
        return root;
    }

    /**
     * 使用栈
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            TreeNode temp = top.left;
            top.left = top.right;
            top.right = temp;

            if (Objects.nonNull(top.left)) {
                stack.push(top.left);
            }
            if (Objects.nonNull(top.right)) {
                stack.push(top.right);
            }
        }
        return root;
    }

}

