package vip.ruoyun.week2.lesson8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 */
public class Leetcode17 {

    private static HashMap<String, List<String>> hashMap = new HashMap<>();

    static {
        hashMap.put("2", Arrays.asList("a", "b", "c"));
        hashMap.put("3", Arrays.asList("d", "e", "f"));
        hashMap.put("4", Arrays.asList("g", "h", "i"));
        hashMap.put("5", Arrays.asList("j", "k", "l"));
        hashMap.put("6", Arrays.asList("m", "n", "o"));
        hashMap.put("7", Arrays.asList("p", "q", "r", "s"));
        hashMap.put("8", Arrays.asList("t", "u", "v"));
        hashMap.put("9", Arrays.asList("w", "x", "y", "z"));
    }


    public static List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        handle("", resultList, digits);
        return resultList;
    }

    public static void handle(String combination, List<String> resultList, String digits) {
        if (digits.length() == 0) {
            resultList.add(combination);
        } else {
            String res = digits.substring(0, 1);
            List<String> list = hashMap.get(res);
            for (String s : list) {
                handle(combination + s, resultList, digits.substring(1));
            }
        }
    }

    //     2
    //   a  b   c
    //
    //
    //

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }


}
