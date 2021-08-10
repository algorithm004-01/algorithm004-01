package homework.week08;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @author: sintang
 * @date: 2019-12-08
 */
public class LeetCode_387_501 {
    /**
     * 暴力
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        Character c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(map.get(c) == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 记录每个字符出现了几次，然后获取
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        int[] letter = new int[26];
        for (char c : s.toCharArray()) {
            letter[c - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(letter[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 使用api 获取到最后一次出现此字符和第一次出现此字符是否相等
     * @param s
     * @return
     */
    public int firstUniqChar3(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(s.indexOf(ch) == s.lastIndexOf(ch)){
                return i;
            }
        }
        return -1;
    }
}
