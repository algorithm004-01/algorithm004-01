package com.mrglint.leetcode.week07.solution242;

/**
 * @author luhuancheng
 * @since 2019-11-28 22:21
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cache = new int[26];
        for (char c : s.toCharArray()) {
            cache[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cache[c - 'a']--;
            if (cache[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

