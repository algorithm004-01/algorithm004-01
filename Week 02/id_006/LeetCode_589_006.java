package com.mrglint.leetcode.week02.solution589;

import com.mrglint.leetcode.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-10-26 20:57
 */
public class Solution {
    // 递归写法
    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }
    private void preorder(Node node, List<Integer> result) {
        if (Objects.isNull(node)) {
            return;
        }
        result.add(node.val);
        if (Objects.nonNull(node.children)) {
            for (Node item : node.children) {
                preorder(item, result);
            }
        }
    }

    // 迭代写法
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            if (Objects.nonNull(top)) {
                result.add(top.val);
                if (Objects.nonNull(top.children)) {
                    for (int i = top.children.size() - 1; i >= 0; i--) {
                        stack.push(top.children.get(i));
                    }
                }
            }
        }
        return result;
    }

}

