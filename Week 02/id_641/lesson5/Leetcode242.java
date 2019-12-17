package vip.ruoyun.week2.lesson5;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class Leetcode242 {

    //第一种方法:排序
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }


    //第二种方法:hash 计算和 然后比较值的大小是否相等，有问题
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < c1.length; i++) {
            num1 += c1[i];
            num2 += c2[i];
        }
        return num1 == num2;
    }

    //创建一个 26 位的数组，遍历把数组放进去，第一个数组++ 第二个数组-- 操作
    //最后查看结果是否等于 0，如果是等于 0，那么说明是异味词
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int[] chars = new int[26];
        for (int i = 0; i < c1.length; i++) {
            chars[c1[i] - 'a'] = chars[c1[i] - 'a'] + 1;
            chars[c2[i] - 'a'] = chars[c2[i] - 'a'] - 1;
        }
        for (int count : chars) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
//        String s = "abcgram", t = "bbbgram";
        System.out.println(isAnagram1(s, t));
        System.out.println(isAnagram2(s, t));
        System.out.println(isAnagram3(s, t));
    }
}
