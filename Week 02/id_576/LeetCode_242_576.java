import java.util.Arrays;

/**
 * Leetcode_242_576，判断两个字符串是否是异位词，就是字母都一样，顺序不一样
 */
public class LeetCode_242_576 {
    //1.暴力法，两个字符串sort之后看是否相等，O(nlogn)
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();   
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    // 2. hash表，O(n),创建一个a-z，的int数组，记录s中字符的频次（加），并在t中减，最后判断是否为零
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;   
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int ele : counter) {
            if (ele != 0) {
                return false;
            }
        }
        return true;
    }
    
}