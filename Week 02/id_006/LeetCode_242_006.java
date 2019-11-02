package com.mrglint.leetcode.week02.solution242;

/**
 * @author luhuancheng
 * @since 2019-10-25 08:18
 */
public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int c : counter) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}

