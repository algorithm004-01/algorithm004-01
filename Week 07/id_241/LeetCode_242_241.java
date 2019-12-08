import java.util.*;
/**
 * 有效的字母异位词
 */
class Solution {
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int c : arr) {
            if (c != 0)
                return false;
        }
        return true;
    }
}