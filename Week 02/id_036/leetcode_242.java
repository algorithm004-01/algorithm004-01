package com.sslz.leetcode;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode
 * 有效字符
 */
public class leetcode_242 {

    /**
     * 解法一 将字符串进行排序 然后在判断是相等
     *
     * @param str1
     * @param str2
     * @return
     */
    static boolean solution_01(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (String.valueOf(c1).equals(String.valueOf(c2))) {
            return true;
        }
        return false;
    }

    /**
     * 解法二 ：ASCL 码  char 类型相加减是针对的 ascl 码
     *
     * @param str1
     * @param str2
     * @return
     */
    static boolean solution_02(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] h = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            h[str1.charAt(i) - 'a']++;
            h[str2.charAt(i) - 'a']--;
        }
        for (int i : h) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

}
