/**
 *  387. 字符串中的第一个唯一字符
 */
class Solution {
    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        for (char c:s.toCharArray()) {
            letters[c-'a']++;
        }
        for (int i=0;i<s.length();i++) {
            if (letters[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}