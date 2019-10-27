/**
 * 有效的字母异位词
 */
public class Solution {
    /**
     * 转为数组，排序，并比较是否相同
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.toString(ss).equals(Arrays.toString(tt));
    }

    /**
     * 模拟 hash 函数散列码，桶中每个下标计数出现次数，最后遍历是否有不为 0 的
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int c : arr) {
            if (c != 0)
                return false;
        }
        return true;
    }

    /**
     * 第一次循环计数 s 字符串，第二次循环以减法计数 t 字符串，如果出现小于 0，则表示出现不同字符
     */
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) {
            if (--arr[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}
