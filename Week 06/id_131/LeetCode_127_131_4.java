package com.lzhlyle.leetcode.self.no127;

import java.util.*;

public class WordLadder_ViaTemplate_Set {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // base condition
        if (!wordList.contains(endWord)) return 0;
        if (beginWord.equals(endWord) || beginWord.length() == 1) return 2;

        int level = 1;
        Set<String> meets = new HashSet<>(wordList); // O(1) for looking up

        Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singleton(endWord));

        // terminator
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // process
            level++;

            // always from less to more
            if (beginSet.size() > endSet.size()) {
                Set<String> swap = beginSet;
                beginSet = endSet;
                endSet = swap;
            }

            meets.removeAll(beginSet); // 避免找回头

            Set<String> nextBegin = new HashSet<>();
            // each word in begin set
            for (String begin : beginSet) {
                List<String> children = this._getChildren(begin);
                for (String child : children) {
                    // pruning
                    if (!meets.contains(child)) continue;
                    // terminator
                    if (endSet.contains(child)) return level; // meet
                    nextBegin.add(child);
                }
            }

            // drill down
            beginSet = nextBegin;
        }

        return 0; // cannot meet
    }

    private List<String> _getChildren(String begin) {
        List<String> res = new ArrayList<>();
        char[] chars = begin.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (temp == c) continue;
                chars[i] = c;
                res.add(String.valueOf(chars));
            }
            // reverse
            chars[i] = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new WordLadder_ViaTemplate_Set().ladderLength("hit", "dot",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(res);
    }
}
