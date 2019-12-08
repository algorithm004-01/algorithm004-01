package com.lzhlyle.leetcode.self.no49;

import java.util.*;

public class GroupAnagrams_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) return null;
        if (strs.length == 1) return Collections.singletonList(Collections.singletonList(strs[0]));

        // 暴力加速 质数相乘
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Integer uniqKey = _generateUniqKeyForAnagram(str);
            if (!map.containsKey(uniqKey)) {
                map.put(uniqKey, new ArrayList<>());
            }
            map.get(uniqKey).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private static final int[] _PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
            67, 71, 73, 79, 83, 89, 97, 101, 107};

    private Integer _generateUniqKeyForAnagram(String str) {
        char[] arr = str.toCharArray();
        int res = 1;
        for (char c : arr) {
            res = res * _PRIMES[c - 'a'];
        }
        return res;
    }
}
