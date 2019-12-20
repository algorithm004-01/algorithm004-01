package com.lzhlyle.leetcode.recite.no387;

public class FirstUniqueCharacterInAString_2 {
    public int firstUniqChar(String s) {
        // base condition
        if (s == null || s.length() < 1) return -1;

        int[] counts = new int[26];

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            counts[chars[i] - 'a'] += 1;
        }

        for (int i = 0; i < chars.length; i++) {
            if (counts[chars[i] - 'a'] == 1) return i;
        }

        return -1;
    }
}
