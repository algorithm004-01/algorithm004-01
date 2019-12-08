package homework.week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * [242] 有效的字母异位词
 * 字母异位词:两个字符串中的字母出现次数一样，就是字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/description/
 */
public class ValidAnagram {
    
    /**
     * 暴力法
     * 思路：如果是异位词，字符串字母从小到大排序后，应该是相等的
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
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
     * 思路：
     * 判断两个字符串中字符出现的次数是否一样。
     * 
     * 执行用时 :73 ms, 在所有 java 提交中击败了5.77%的用户
     * 内存消耗 :38.3 MB, 在所有 java 提交中击败了92.52%的用户
     * (-_-)!!
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<String,Integer> resultMap = new HashMap<>();
        Integer num1 = 0;
        Integer num2 = 0;
        String str1 = "";
        String str2 = "";
        for(int i = 0;i < s.length(); i ++){
            str1 = "s" + s.charAt(i);
            // 此步重要
            str2 = "t" + t.charAt(i);
            num1 = resultMap.get(str1);
            num2 = resultMap.get(str2);
            if(num1 == null){
                num1 = 0;
            }
            if(num2 == null){
                num2 = 0;
            }
            num1 ++;
            num2 ++;
            resultMap.put(str1, num1);
            resultMap.put(str2, num2);
        }
        for(int i = 0;i < s.length(); i ++){
            str1 = "s" + s.charAt(i);
            str2 = "t" + s.charAt(i);
            if(!resultMap.get(str1).equals(resultMap.get(str2))){
                return false;
            }
        }
        return true;
    }

    /**
     * 思路：
     * 先用计数器表计算 s，然后用 t 减少计数器表中的每个字母的计数器。如果在任何时候计数器低于零，
     * 我们知道 t 包含一个不在 s 中的额外字母，并立即返回 FALSE。
     * https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for(int i = 0; i < s.length(); i++){
            table[s.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < t.length(); i++){
            table[t.charAt(i) - 'a']--;
            if(table[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        // boolean result = isAnagram(s,t);
        boolean result = isAnagram2(s,t);
        System.out.println(result);
    }
}

