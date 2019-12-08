package homework.week07;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram
 * @author tangxy
 * @date 2019-12-01
 */
public class LeetCode_242_501 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
