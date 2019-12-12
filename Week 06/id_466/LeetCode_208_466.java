//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例:
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");
//trie.search("app");     // 返回 true
//
// 说明:
//
//
// 你可以假设所有的输入都是由小写字母 a-z 构成的。
// 保证所有输入均为非空字符串。
//
// Related Topics 设计 字典树
package com.aseara.leetcode.editor.cn.a208;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * desc: 208.实现 Trie (前缀树) <br />
 * Date: 2019/11/19 <br/>
 *
 * @author qiujingde
 */
class ImplementTriePrefixTree {

    @Test
    void test1() {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            node = node.computeIfAbsent(c);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = getEndNode(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = getEndNode(prefix);
        return node != null;
    }

    public TrieNode getRoot() {
        return root;
    }

    private TrieNode getEndNode(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length && node != null; i++) {
            node = node.getNode(chars[i]);
        }
        return node;
    }

    static class TrieNode {
        private Map<Character, TrieNode> links = new HashMap<>();

        private boolean isEnd;

        public TrieNode computeIfAbsent(char c) {
            return links.computeIfAbsent(c, k -> new TrieNode());
        }

        public TrieNode getNode(char c) {
            return links.get(c);
        }

        public void setNode(char c, TrieNode node) {
            links.put(c, node);
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
