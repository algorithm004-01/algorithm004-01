class TrieNode {
    char val;
    boolean isWord;
    TrieNode[] chirld = new TrieNode[26];
    TrieNode(){}
    TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}
public class Trie {
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode next = root;
        for (char c : word.toCharArray()) {
            if (next.chirld[c-'a'] == null) {
                next.chirld[c-'a'] = new TrieNode(c);
            }
            next = next.chirld[c-'a'];
        }
        next.isWord = true;
    }
    public boolean search(String word) {
        TrieNode next = root;
        for (char c : word.toCharArray()) {
            if (next.chirld[c-'a'] == null) return false;
            else next = next.chirld[c-'a'];
        }
        return next.isWord;
    }
    public boolean startsWith(String prefix) {
        TrieNode next = root;
        for (char c : prefix.toCharArray()) {
            if (next.chirld[c-'a'] == null) return false;
            else next = next.chirld[c-'a'];
        }
        return true;
    }
}
