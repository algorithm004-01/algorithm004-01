/**
 * 205. 同构字符串
 */
 class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(schars[i]) != t.indexOf(tchars[i])) {
                return false;
            }
        }
        return true;
    }
}