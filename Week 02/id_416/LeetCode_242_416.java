package com.leetcode.week02;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
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
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_242_416 {
    //1.string to char[] then sort char[] last Arrays.equals()
    //时间复杂度为O (nlogn)
    public boolean isAnagram0(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }
    //2.hash table , 26 int[] table
    //26个字母每个字母减去 a，就是对应0~25个下标，让当前字符串，让字符在数组中遍历，一个相加，一个相减
    //最后肯定都为0
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for(int i=0;i<s.length();i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < counter.length; i++) {
            int i1 = counter[i];
            if(i1 != 0) {
                return false;
            }
        }
        return true;
    }
    //3.hash table ，先将一个字符串++ ，然后在将另外一个字符串--，因为字符串长度是相等的，
    // 只要有一个小于零，那么就说明
    public boolean isAnagram2(String s, String t){
        if(s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];

        for(int i=0;i<s.length();i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for(int i = 0;i<t.length();i++) {
            counter[t.charAt(i) - 'a']--;
            if(counter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    //3.简化代码的写法,根据第三种办法简化了代码
    public boolean isAnagram22(String s, String t){
        if(s.length() != t.length()) return  false;
        int[] counter = new int[26];
        for(int i=0;i<s.length();i++) counter[s.charAt(i) - 'a']++;
        for(int i = 0;i<t.length();i++) if(--counter[t.charAt(i) - 'a'] < 0) return false;
        return true;
    }


}
