package com.lzhlyle.leetcode.self.no208;

class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.contains(c)) curr.set(c, new TrieNode());
            curr = curr.get(c);
        }
        curr.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode last = searchPrefix(word);
        return last != null && last.isEnd();
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            curr = curr.get(c);
            if (curr == null) return null;
        }
        return curr;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}

class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;

    TrieNode() {
        links = new TrieNode[26];
    }

    public void set(char c, TrieNode next) {
        links[c - 'a'] = next;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public boolean contains(char c) {
        return links[c - 'a'] != null;
    }

    public boolean isEnd() {
        return isEnd;
    }

    void setEnd() {
        isEnd = true;
    }
}
