import java.util.*;
/**
 * 实现 Trie (前缀树)
 */
class Trie {

    private Trie[] node;
    private boolean isEnd;

    public Trie() {
        this.node = new Trie[26];
    }

    public void insert(String word) {
        Trie curr = this;
        for (char w : word.toCharArray()) {
            if (curr.node[w - 'a'] == null) curr.node[w - 'a'] = new Trie();
            curr = curr.node[w - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = searchPrefix(word);
        return curr != null && curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String word) {
        char[] arr = word.toCharArray();
        Trie curr = this;
        for (char w : arr) {
            if (curr == null) break;
            curr = curr.node[w - 'a'];
        }
        return curr;
    }
}