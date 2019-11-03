import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/valid-anagram/
// 异位词是字母相同，位置不同的两个词
public class LeetCode_242_716 {
    // 1. 排序法，对两个字符串排序后比较
    public boolean isAnagram1(String s, String t) {
        // sort s -> s'
        String sortedS = sort(s);

        // sort t -> t'
        String sortedT = sort(t);

        // s'.equals(t') ?
        return sortedS.equals(sortedT);
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    // 2. hash表统计字母的出现频次，s增加频次，t减少频次
    // 2.1 实现, 通用实现
    public boolean isAnagram21(String s, String t) {
        if (s.length() != t.length()) return false;

        // 把每个出现的字符及频次都放在hash表中
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int freqInS = charFreq.getOrDefault(s.charAt(i), 0);
            charFreq.put(s.charAt(i), freqInS + 1);

            int freqInT = charFreq.getOrDefault(t.charAt(i), 0);
            charFreq.put(t.charAt(i), freqInT - 1);
        }
        // 判断hash表中的key对应的频次都为0才是异位词
        for (int freq : charFreq.values()) {
            if (freq != 0) return false;
        }
        return true;
    }

    // 2.2 实现，利用26个字母
    public boolean isAnagram22(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] alphabet = new int[26];
        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            alphabet[c - 'a']--;
            if (alphabet[c - 'a'] < 0) return false;
        }
        return true;
    }

    // 2.3 实现
    public boolean isAnagram23(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int freq : alphabet) {
            if (freq != 0) return false;
        }
        return true;
    }
}