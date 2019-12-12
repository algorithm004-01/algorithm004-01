package com.mrglint.leetcode.week02.solution144;

import com.mrglint.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-10-26 07:07
 */
public class Solution {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }
    private void preorderTraversal(TreeNode node, List<Integer> result) {
        if (Objects.isNull(node)) {
            return;
        }
        result.add(node.val);
        preorderTraversal(node.left, result);
        preorderTraversal(node.right, result);
    }

    /**
     * 栈写法一
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                result.add(currentNode.val);
                currentNode = currentNode.left;
            }
            TreeNode stackTop = stack.pop();
            currentNode = stackTop.right;
        }
        return result;
    }

    /**
     * 栈写法二
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode stackTop = stack.pop();
            result.add(stackTop.val);
            if (Objects.nonNull(stackTop.right)) {
                stack.push(stackTop.right);
            }

            if (Objects.nonNull(stackTop.left)) {
                stack.push(stackTop.left);
            }
        }
        return result;
    }

    /**
     * 栈写法三：简化判空代码
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (Objects.nonNull(pop)) {
                result.add(pop.val);
                stack.push(pop.right);
                stack.push(pop.left);
            }
        }
        return result;
    }
}

