/**
 *给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 */
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         char[] charS = s.toCharArray();
//         char[] charT = t.toCharArray();
//         Arrays.sort(charS);
//         Arrays.sort(charT);
//         return Arrays.equals(charS, charT);
//     }
// }
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0 ) return false;
        }
        return true;
    }
}