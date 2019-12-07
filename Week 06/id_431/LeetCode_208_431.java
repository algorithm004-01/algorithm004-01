package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘磊明
 * @date 2019/11/21
 */
public class ImplementTrie {
    TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            if (!node.children.containsKey(chars[i])){
                node.children.put(chars[i], new TrieNode(chars[i]));
            }
            node = node.children.get(chars[i]);
            // 设置结尾标志
            if (i == chars.length - 1) {
                node.isEnd = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            if (!node.children.containsKey(chars[i])) return false;
            node = node.children.get(chars[i]);
            if (i == chars.length - 1) {
                return node.isEnd;
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            if (!node.children.containsKey(chars[i])) return false;
            node = node.children.get(chars[i]);
        }
        return true;
    }

    private class TrieNode {
        Map<Character, TrieNode> children;
        Character val;
        Boolean isEnd;

        TrieNode() {
            isEnd = false;
            children = new HashMap<>();
        }

        TrieNode(Character c) {
            this.val = c;
            isEnd = false;
            children = new HashMap<>();
        }
    }
}
