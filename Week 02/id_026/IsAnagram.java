package com.abc.week02;

// 字母异位词
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "anagram";
        String b = "nagaram";
        IsAnagram anagram = new IsAnagram();
        System.out.println(anagram.isAnagram(a, b));
    }
}
