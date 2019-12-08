package com.mrglint.leetcode.week06.solution212;

import java.util.*;

/**
 * 1. 将单词列表构建Trie树
 * 2. 遍历board中的每个字母作为单词开头，从该字母DFS继续遍历。将走过的路径到Trie中查找，如果存在的话就放到结果集中（注意同一单元格内的字母在一个单词中不允许重复使用）
 * @author luhuancheng
 * @since 2019-11-19 07:16
 */
public class Solution {

    /**
     * 四连通图的坐标偏移
     */
    private final static int[][] DIRECTIONS = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private  static class Trie {

        private static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean endWord;

            boolean containsKey(char c) {
                return children[c - 'a'] != null;
            }

            TrieNode put(char c) {
                children[c - 'a'] = new TrieNode();
                return children[c - 'a'];
            }

            TrieNode get(char c) {
                return children[c - 'a'];
            }

            public boolean isEndWord() {
                return endWord;
            }

            public void setEndWord(boolean endWord) {
                this.endWord = endWord;
            }
        }

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
            root.endWord = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (node.containsKey(c)) {
                    node = node.get(c);
                } else {
                    node = node.put(c);
                }
            }
            node.setEndWord(true);
        }

        private TrieNode searchNode(String word) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (node.containsKey(c)) {
                    node = node.get(c);
                } else {
                    return null;
                }
            }
            return node;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode trieNode = searchNode(word);
            return trieNode != null && trieNode.endWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchNode(prefix) != null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> result = new HashSet<>();

        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dfs(row, col, rows, cols, board, "", trie, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(int row, int col, int rows, int cols, char[][] board, String tempWord, Trie trie, Set<String> result) {
        if (!validateCoordinate(board, row, rows, col, cols)) {
            return;
        }

        tempWord = tempWord + board[row][col];
        char temp = board[row][col];
        board[row][col] = '#';

        Trie.TrieNode trieNode = trie.searchNode(tempWord);
        if (Objects.nonNull(trieNode)) {
            if (Objects.equals(trieNode.endWord, true)) {
                result.add(tempWord);
            }
            for (int[] direction : DIRECTIONS) {
                dfs(row + direction[0], col + direction[1], rows, cols, board, tempWord, trie, result);
            }
        }
        board[row][col] = temp;
    }

    private boolean validateCoordinate(char[][] board, int row, int rows, int col, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] != '#';
    }
}

