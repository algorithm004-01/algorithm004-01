package com.mrglint.leetcode.week03.solution127;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2019-11-01 07:09
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        char[] initialTable = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'};
        // 使用map作为去重判断，不然会超时
        Map<String, Boolean> map = new HashMap<>(wordList.size());
        for (String s : wordList) {
            map.put(s, true);
        }

        if (!map.containsKey(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        map.remove(beginWord);
        int transformationCount = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String queueHead = queue.poll();
                if (Objects.equals(queueHead, endWord)) {
                    return transformationCount;
                }
                for (int i = 0; i < beginWord.length(); i++) {
                    for (char c : initialTable) {
                        char[] chars = queueHead.toCharArray();
                        if (chars[i] != c) {
                            chars[i] = c;
                            String variant = new String(chars);

                            if (map.containsKey(variant)) {
                                map.remove(variant);
                                queue.offer(variant);
                            }
                        }
                    }
                }
            }
            transformationCount++;
        }
        return 0;
    }
}

