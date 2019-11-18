package com.mrglint.leetcode.week02.solution590;

import com.mrglint.leetcode.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 *
 * @author luhuancheng
 * @since 2019-10-26 07:40
 */
public class Solution {

    /**
     * 递归写法
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    private void postorder(Node node, List<Integer> result) {
        if (Objects.isNull(node)) {
            return;
        }
        if (Objects.nonNull(node.children)) {
            for (Node e : node.children) {
                postorder(e, result);
            }
        }
        result.add(node.val);
    }

    /**
     * 迭代写法
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            if (Objects.nonNull(top)) {
                result.add(0, top.val);
                if (Objects.nonNull(top.children)) {
                    for (Node e : top.children) {
                        stack.push(e);
                    }
                }
            }
        }
        return result;
    }

}

