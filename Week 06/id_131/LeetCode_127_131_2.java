package com.lzhlyle.leetcode.self.no127;

import java.util.*;

public class WordLadder_ViaTemplate_Queue {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // base condition
        if (!wordList.contains(endWord)) return 0;
        if (beginWord.equals(endWord) || beginWord.length() == 1) return 2;

        int level = 1;
        Set<String> meets = new HashSet<>(wordList); // O(1) for looking up

        Queue<String> beginQueue = new LinkedList<>(Collections.singleton(beginWord));
        Queue<String> endQueue = new LinkedList<>(Collections.singleton(endWord));

        // terminator
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            // process
            level++;

            Queue<String> nextBegin = new LinkedList<>();
            // each word in begin queue
            meets.removeAll(beginQueue); // 避免找回头
            while (!beginQueue.isEmpty()) {
                String begin = beginQueue.remove();

                List<String> children = this._getChildren(begin);
                for (String child : children) {
                    // pruning
                    if (!meets.contains(child)) continue;
                    // terminator
                    if (endQueue.contains(child)) return level; // meet
                    nextBegin.add(child);
                }
            }

            // drill down
            beginQueue = nextBegin;
            // always from less to more
            if (beginQueue.size() > endQueue.size()) {
                Queue<String> swap = beginQueue;
                beginQueue = endQueue;
                endQueue = swap;
            }
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
        int res = new WordLadder_ViaTemplate_Queue().ladderLength("hit", "dot",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(res);
    }
}
