package com.lqw.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 * 思考：
 * 1、一直加左括号，但不能超过对数
 * 2、左括号大于右括号才能加右括号
 *
 */
public class SolutionOne {

    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        //自顶向下
        return generate(0, 0, n, "", parenthesis);
    }

    private List<String> generate(int left, int right, int max, String s, List<String> parenthesis) {
        //terminator终止条件
        if (left == max && right == max) {
            parenthesis.add(s);
            return parenthesis;
        }

        //process处理当前逻辑

        //drill down
        //加左括号
        if (left < max) {
            generate(left + 1, right, max, s + "(", parenthesis);
        }

        //加右括号
        if (right < left) {
            generate(left, right + 1, max, s + ")", parenthesis);
        }

        return parenthesis;
    }

    public static void main(String[] args) {
        SolutionOne solutionOne = new SolutionOne();
        solutionOne.generateParenthesis(4);
    }
}
