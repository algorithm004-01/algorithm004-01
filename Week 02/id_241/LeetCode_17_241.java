import java.util.*;
/**
 * 电话号码的字母组合
 */
public class Solution {
    /**
     * 电话号码的字母组合
     */
    List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        Map<Character, String> map = new HashMap<>(10);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        letterCombinationsHelper(digits, map, 0, "");
        return res;
    }

    private void letterCombinationsHelper(String digits, Map<Character, String> map, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsHelper(digits, map, index + 1, s + letters.charAt(i));
        }
    }
}