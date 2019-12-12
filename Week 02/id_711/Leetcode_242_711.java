package Week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_242 {
    public static void main(String[] args) {
        String s = "asia";
        String t = "siaa";
        System.out.println(isAnagram2(s,t));

    }

    /**
     * 排序后比较是否相等
     * 执行用时 :4 ms, 在所有 java 提交中击败了94.06%的用户
     * 内存消耗 :38 MB, 在所有 java 提交中击败了95.65%的用户
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        return Arrays.equals(sarr,tarr);
    }

    /**
     * 题解哈希
     * 执行用时 :8 ms, 在所有 java 提交中击败了68.25%的用户
     * 内存消耗 :37.4 MB, 在所有 java 提交中击败了95.90%的用户
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count:counter) {
            if (count != 0)
                return false;
        }
        return true;
    }

    /**
     * 题解哈希变种：计数器
     * 执行用时 :5 ms, 在所有 java 提交中击败了86.49%的用户
     * 内存消耗 :37.5 MB, 在所有 java 提交中击败了95.80%的用户
     */
    private static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
