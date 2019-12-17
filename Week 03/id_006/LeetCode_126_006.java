package com.mrglint.leetcode.week03.solution126;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2019-11-01 08:26
 */
public class Solution {
    /**
     * 字典
     */
    private char[] initialTable = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'};

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        /**
         * 使用hashset提供O(1)的时间复杂度的读取操作
         */
        Set<String> dictionary = new HashSet<>(wordList);

        List<List<String>> result = new ArrayList<>();
        if (!dictionary.contains(endWord)) {
            return result;
        }

        Map<String, Integer> distance = getDistance(beginWord, endWord, new HashSet<>(dictionary));

        List<String> subResult = new LinkedList<>();
        subResult.add(beginWord);
        findLadders(beginWord, endWord, dictionary, distance, subResult, result);
        return result;
    }

    /**
     * 广度优先搜索，获取到最短路径上，字符串所在节点的深度
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private Map<String, Integer> getDistance(String beginWord, String endWord, Set<String> wordList) {
        Map<String, Integer> distance = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();

            // 同一层遍历完毕
            while (size-- > 0) {
                String queueHead = queue.poll();
                if (!distance.containsKey(queueHead)) {
                    distance.put(queueHead, level);
                }
                if (Objects.equals(queueHead, endWord)) {
                    found = true;
                }
                for (int i = 0; i < queueHead.length(); i++) {
                    char[] chars = queueHead.toCharArray();
                    for (char c : initialTable) {
                        char temp = chars[i];
                        if (c != chars[i]) {
                            chars[i] = c;
                            String newString = new String(chars);
                            if (wordList.contains(newString)) {
                                wordList.remove(newString);
                                queue.offer(newString);
                            }
                        }
                        chars[i] = temp;
                    }
                }
            }
            level++;
            if (found) {
                break;
            }
        }
        return distance;
    }

    /**
     * 深度优先搜索，计算最短路径。
     * 借助
     * @param beginWord
     * @param endWord
     * @param dictionary
     * @param subResult
     * @param result
     */
    private void findLadders(String beginWord, String endWord, Set<String> dictionary, Map<String, Integer> distance, List<String> subResult, List<List<String>> result) {
        // terminator
        if (Objects.equals(beginWord, endWord)) {
            result.add(subResult);
            return;
        }

        // process current level logic
        for (int i = 0; i < beginWord.length(); i++) {
            char[] chars = beginWord.toCharArray();
            for (char c : initialTable) {
                if (chars[i] != c) {
                    char temp = chars[i];
                    chars[i] = c;
                    String newString = new String(chars);
                    if (dictionary.contains(newString)) {
                        // drill down
                        subResult.add(newString);
                        dictionary.remove(newString);
                        // 1. 获取不到距离的，说明该字符串所在路径非最短路径
                        // 2. 如果当前字符串的距离 + 1 == 下一个节点字符串的距离 说明这两个字符串所在路径为最短路径上的节点
                        if (Objects.nonNull(distance.get(beginWord)) && Objects.nonNull(distance.get(newString)) && distance.get(beginWord) + 1 == distance.get(newString)) {
                            findLadders(newString, endWord, dictionary, distance, new ArrayList<>(subResult), result);
                        }

                        // restore state
                        subResult.remove(subResult.size() - 1);
                        dictionary.add(newString);
                    }
                    chars[i] = temp;
                }
            }
        }
    }
}

