import java.util.HashMap;
import java.util.Map;

public class LeetCode_242_ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new LeetCode_242_ValidAnagram().new Solution();
        assert solution.isAnagram("anagram", "nagaram");
        assert !solution.isAnagram("a", "ab");
        assert !solution.isAnagram("ab", "a");
        assert !solution.isAnagram("ab", "ac");
    }

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            Map<Character, Integer> charMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (charMap.containsKey(c)) {
                    charMap.put(c, charMap.get(c) + 1);
                } else {
                    charMap.put(c, 1);
                }
            }
            for (char c : t.toCharArray()) {
                if (charMap.containsKey(c) && charMap.get(c) > 0) {
                    charMap.put(c, charMap.get(c) - 1);
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}