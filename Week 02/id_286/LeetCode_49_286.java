package com.uanei;

import java.util.*;

public class LeetCode_49_286 {

    /**
     * 解法：字符串排序之后相等则是异位词
     * 时间复杂度：O(NKlogK)，logk主要是对每个字符串的排序时间复杂度
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 无元素，直接返回空集合
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        // 记录排序之后字符串以及它的异位词集合
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            // 转字符数组
            char[] strA = str.toCharArray();
            // 排序
            Arrays.sort(strA);

            // 排序之后的字符串当成key
            String key = String.valueOf(strA);
            // 如果map中不存在，则初始化一个集合
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            // 对异位词进行统计
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

}
