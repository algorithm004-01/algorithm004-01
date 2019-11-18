package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/27
 */
public class LetterCombinationsOfAPhoneNumber {
//    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
//
//    public List<String> letterCombinations(String digits) {
//
//        List<String> ret = new LinkedList<String>();
//        combination("", digits, 0, ret);
//        return ret;
//    }
//
//    private void combination(String prefix, String digits, int offset, List<String> ret) {
//        if(digits == null || digits.length() == 0) return;
//        if (offset >= digits.length()) {
//            ret.add(prefix);
//            return;
//        }
//        String letters = KEYS[(digits.charAt(offset) - '0')];
//        for (int i = 0; i < letters.length(); i++) {
//            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
//        }
//    }

    private String[] keys = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) return Collections.emptyList();
        List<String> list = new ArrayList<>();
        traversal(new StringBuilder(), digits, 0, list);
        return list;
    }

    private void traversal(StringBuilder priex, String digits, int offset, List<String> result){
        if (offset > digits.length() - 1) result.add(priex.toString());
        else {
            String letter = keys[digits.charAt(offset) - '0'];
            for (int i = 0; i < letter.length(); i++) {
                priex.append(letter.charAt(i));
                traversal(priex, digits, offset + 1, result);
                priex.delete(priex.length() - 1, priex.length());
            }
        }
    }
}
