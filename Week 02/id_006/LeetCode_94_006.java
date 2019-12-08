package com.mrglint.leetcode.week02.solution94;

import com.mrglint.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-10-25 22:16
 */
public class Solution {
    // 递归写法
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal1(root, result);
        return result;
    }
    private void inorderTraversal1(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderTraversal1(node.left, result);
        result.add(node.val);
        inorderTraversal1(node.right, result);
    }

    // 栈写法
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            // 遍历到左子树为空为止
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            // 左子树最后一个不为空的节点
            currentNode = stack.pop();
            // 放入结果集
            result.add(currentNode.val);
            // 当前节点指针指向左子树最后一个不为空的节点的右子树根节点
            currentNode = currentNode.right;
        }
        return result;
    }
}

