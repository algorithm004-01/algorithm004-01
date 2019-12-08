/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (62.45%)
 * Likes:    151
 * Dislikes: 0
 * Total Accepted:    17.1K
 * Total Submissions: 27.3K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start
class Trie {
    public boolean isWord;
    public char word;
    public Trie[] tries = new Trie[26];

    /** Initialize your data structure here. */
    public Trie() {
        this.isWord = false;
        this.word = ' ';

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] array = word.toCharArray();
        Trie node = this;
        for (int i = 0; i < array.length; i++) {
            if (node.tries[array[i] - 'a'] == null) {
                node.tries[array[i] - 'a'] = new Trie();
            }
            node = node.tries[array[i] - 'a'];
            node.word = array[i];
            if (i == array.length - 1) {
                node.isWord = true;
            }
        }

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] array = word.toCharArray();
        Trie node = this;
        for (int i = 0; i < array.length; i++) {
            if (node.tries[array[i] - 'a'] != null) {
                node = node.tries[array[i] - 'a'];
                if (node.word == array[i])
                    continue;
                else
                    return false;
            } else
                return false;

        }
        return node.isWord == true ? true : false;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] array = prefix.toCharArray();
        Trie node = this;
        for (int i = 0; i < array.length; i++) {
            if (node.tries[array[i] - 'a'] != null) {
                node = node.tries[array[i] - 'a'];
                if (node.word == array[i])
                    continue;
                else
                    return false;
            } else
                return false;

        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end
