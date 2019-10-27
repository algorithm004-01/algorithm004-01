package com.uanei;

import java.util.Arrays;

public class LeetCode_242_286 {

    /**
     * 暴力解法：先排序后比较
     */
    public boolean isAnagram1(String s, String t) {
        // 长度不相同则直接返回false
        if (s.length() != t.length()) {
            return false;
        }

        // 排序
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        // 直接对数组进行重排序
        Arrays.sort(sa);
        Arrays.sort(ta);

        return Arrays.equals(sa, ta);
    }

    /**
     * hash 解法：将所有的字符放到map中，统计每一个字符出现的次数
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 一共只有26个字母，将字母映射到26个长度的数组中，下标通过ascii计算
        int[] counter = new int[26];
        char a = 'a';

        for (int i = 0; i < s.length(); i++) {
            // 第一个字符串中出现次数增加
            counter[s.charAt(i) - a]++;
            // 第二个字符串中出现次数减少
            counter[t.charAt(i) - a]--;
        }

        // 最后比较出现次数的抵消结果是不是0
        for (int i : counter) {
            // 说明其中某个字符出现的次数不相同
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

}
