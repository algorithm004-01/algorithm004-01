package com.mrglint.leetcode.week02.solution49;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2019-10-25 08:53
 */
public class Solution {

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> cache = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!cache.containsKey(key)) {
                cache.put(key, new ArrayList<>());
            }
            cache.get(key).add(s);
        }
        return new ArrayList<>(cache.values());
    }

    /**
     * 通过将字符串转换为 「#1#2#3...#2」这样的字符串，作为key放到map中，避免使用排序算法
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> cache = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] counter = new int[26];
            for (char c : strs[i].toCharArray()) {
                counter[c - 'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int n : counter) {
                keyBuilder.append("#");
                keyBuilder.append(n);
            }
            String key = keyBuilder.toString();
            if (!cache.containsKey(key)) {
                cache.put(key, new ArrayList<>());
            }
            cache.get(key).add(strs[i]);
        }
        return new ArrayList<>(cache.values());
    }
}
