package com.lzhlyle.leetcode.self.no127;

import java.util.*;

public class WordLadder_ViaTemplate_Recursion {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // base condition
        if (!wordList.contains(endWord)) return 0;
        if (beginWord.equals(endWord) || beginWord.length() == 1) return 2;

        int level = 1;

        // initial
        Set<String> meets = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singleton(endWord));

        return this.searchBfs(level, meets, beginSet, endSet);
    }

    private int searchBfs(int level, Set<String> meets, Set<String> beginSet, Set<String> endSet) {
        // terminator
        if (beginSet.size() == 0 || endSet.size() == 0) return 0; // cannot find

        // process
        level++;
        // always from less to more
        if (beginSet.size() > endSet.size()) {
            Set<String> swap = beginSet;
            beginSet = endSet;
            endSet = swap;
        }

        // each word in begin
        Set<String> nextBegin = new HashSet<>();
        meets.removeAll(beginSet);
        for (String begin : beginSet) {
            List<String> neighbors = this._getNeighbors(begin);
            for (String neighbor : neighbors) {
                if (!meets.contains(neighbor)) continue;
                if (endSet.contains(neighbor)) return level;
                nextBegin.add(neighbor);
            }
        }
        beginSet = nextBegin;

        // drill down
        return this.searchBfs(level, meets, beginSet, endSet);

        // reverse state
    }

    private List<String> _getNeighbors(String word) {
        List<String> res = new ArrayList<>();
        char[] chars = word.toCharArray();
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
}
