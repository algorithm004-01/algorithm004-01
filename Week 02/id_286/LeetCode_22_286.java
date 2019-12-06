package com.uanei;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_286 {

    /**
     * 思路：n就是递归层数，左括号或者右括号出现的次数等于n，左出现之后才能有右
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        _generate(0, 0, n, "", res);
        return res;
    }

    private void _generate(int left, int right, int n, String s, List<String> res) {
        // 终结条件：出现的对数够了
        if (left == n && right == n) {
            res.add(s);
            return;
        }

        // 左括号先出现，递归层数限制之内
        if (left < n) _generate(left + 1, right, n, s + "(", res);
        // 右括号必须在有左括号前提下才能出现，层数已经有左括号限制了
        if (left > right) _generate(left, right + 1, n, s + ")", res);
    }

}
