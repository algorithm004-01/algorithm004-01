package com.mrglint.leetcode.week06.solution208;

/**
 * @author luhuancheng
 * @since 2019-11-18 08:43
 */
public class Trie {

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

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.endWord = false;
    }

    /** Inserts a word into the trie. */
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode trieNode = searchNode(word);
        return trieNode != null && trieNode.endWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("word");
        System.out.println(trie.search("word"));
        System.out.println(trie.startsWith("wor"));
        System.out.println(trie.startsWith("dwor"));
    }
}

