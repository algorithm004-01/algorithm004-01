package id_511;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description: 有效的字母异位词(异位词是指字母出现的频率相同但是顺序不同)
 * @author: bingyu
 * @date: 2019/10/30 20:43
 */
public class LeetCode_242_511 {



    //方法一：将字符串按照字母排序，再看是否相等即可
    public static boolean isAnagram(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

    //方法二：使用散列表的思想将字符串的每个字符散列到数组里，并计数
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) { //字符串长度是否相同，不相等肯定不是异位词
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++; //因为字母a在ascii码是97，a在哈希表counter位置是下标0，其它字母的对应的下标就是s.charAt(i) - 'a'；
            counter[t.charAt(i) - 'a']--; //一个加，一个减，如果两个字母是异位词的话，最终数组counter里应该都只有0，否则就不是异位词
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "fsdfsd";
        String t = "vnvnsj";
        boolean f = isAnagram2(s, t);
        System.out.println(f);
    }
}
