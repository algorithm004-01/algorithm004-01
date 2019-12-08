package com.lzhlyle.leetcode.self.no242;

public class ValidAnagram_3 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        // 利用数组记录次数
        int[] arr = new int['z' - 'a' + 1];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            arr[c - 'a']--;
        }

        for (int i : arr) {
            if (i != 0) return false;
        }
        return true;
    }
}
