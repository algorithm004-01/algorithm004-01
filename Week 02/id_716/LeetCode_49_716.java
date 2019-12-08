import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/group-anagrams
// 字母异位词分组
public class LeetCode_49_716 {
    
    // 1. hash 表 + 排序的方式
    // 核心思路是将每个字符串排序后作为key存入hash表，最后输出hash表的所有value
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> resMap = new HashMap<>();
        for (String str : strs) {
            // sort str
            String key = sort(str);

            // add to resMap
            if (!resMap.containsKey(key)) {
                resMap.put(key, new ArrayList<>());
            }
            resMap.get(key).add(str);
        }
        return new ArrayList<>(resMap.values());
    }

    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    // 2. hash 表 + 字符串Counter
    // 核心思路和方法1类似，不同点是hash表中key的生成方式不一样而已
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> resMap = new HashMap<>();
        for (String str : strs) {
            int[] alphabet = new int[26];
            for (char c : str.toCharArray()) {
                alphabet[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int freq : alphabet) {
                sb.append('@');
                sb.append(freq);
            }
            // key
            String key = sb.toString();

            if (!resMap.containsKey(key)) {
                resMap.put(key, new ArrayList<>());
            }
            resMap.get(key).add(str);
        }
        return new ArrayList<>(resMap.values());
    }
}