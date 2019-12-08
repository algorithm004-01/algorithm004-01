class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] bitMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int tempS = s.charAt(i) - 97;
            int tempT = t.charAt(i) - 97;
            bitMap[tempS] = bitMap[tempS] + 1;
            bitMap[tempT] = bitMap[tempT] - 1;
        }

        for (int i = 0; i < 26; i++) {
            if (bitMap[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
