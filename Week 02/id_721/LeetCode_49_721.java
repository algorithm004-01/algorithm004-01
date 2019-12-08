package array;

import java.util.*;

/**
 * @author alis
 * @date 2019/10/23 12:52 PM
 * @description
 */
public class LeetCode_49_721 {
    public List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> result = new HashMap<>();
        for (String anagram : strings) { // 时间复杂度：O(n)
            char[] chars = anagram.toCharArray();
            Arrays.sort(chars);// 快排，时间复杂度为O(klogk)
            String key = String.valueOf(chars);
            if (result.containsKey(key)) {
                result.get(key).add(anagram);
            } else {
                result.put(key, new ArrayList<>(Collections.singletonList(anagram)));
            }
        }
        return new ArrayList<>(result.values());
    }
}
