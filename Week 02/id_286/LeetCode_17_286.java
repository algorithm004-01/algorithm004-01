package com.uanei;

import java.util.*;

public class LeetCode_17_286 {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        // 初始化所有数字的字符串
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        List<String> res = new LinkedList<String>();
        search("", digits, 0, res, map);
        return res;
    }

    private void search(String s, String digits, int i, List<String> res, Map<Character, String> map) {
        // terminator
        // 数字的长度就是递归的深度
        if (i == digits.length()) {
            res.add(s);
            return;
        }

        // process
        // 取到第i个数字的字符串
        String letters = map.get(digits.charAt(i));

        // 遍历当前数字字符串的所有字符进行组合
        for (int j = 0; j < letters.length(); j++) {
            // drill down
            search(s + letters.charAt(j), digits, i + 1, res, map);
        }

        // reverse
    }

}
