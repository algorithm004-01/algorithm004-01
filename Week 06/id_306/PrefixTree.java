package sf.week6;

/**
 * Created by LynnSun on 2019/11/23.
 * 力扣题目地址：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 */
public class PrefixTree {
    private TrieNode root;
    /** Initialize your data structure here. */
    public PrefixTree() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    /**
     * 插入
     * @param word
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    // Returns if the word is in the trie.

    /**
     * 查找
     * @param word
     * @return
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    /**
     * 查找前缀
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

}


