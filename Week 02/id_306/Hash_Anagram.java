import java.util.Arrays;

/**
 * Created by LynnSun on 2019/10/22.
 */
public class Hash_Anagram {
    /**
     * 判断一个两个字符串是否是字母异位词,用数组方式
     * 此方法简单容易想到
     * 思路：把字符串打散成字符数组，然后进行排序，最后判断
     * @param s
     * @param t
     * @return boolean
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * 判断一个两个字符串是否是字母异位词，用Hash方式
     * 思路：利用ASCII码表，采用26长度的数组，拆解字符串病保存字符串中每个字符出现的个数
     * 小技巧：保存个数时，用一个字符串增加，另一个字符串减去的方式，
     *         如果这个字符在两个字符串中出现的个数各自相同，那么个数为0
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_Hash(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // 这里利用了ASCII码的差值找数组位置
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        return Arrays.stream(counts).sum()!=0?false:true;
        /*for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;*/
    }

    /**
     * 没想到的。。。记录下
     * 很巧妙
     * 思路：同上一种方式，但是在拆解第二个字符串时直接计算是不是0
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_Hash2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
