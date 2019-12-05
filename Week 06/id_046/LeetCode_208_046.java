class TrieNode{
    boolean isEnd;
    TrieNode child[];

    public TrieNode(){
        isEnd = false;
        child = new TrieNode[26];
    }
}
class Trie {

    private TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public Trie() {
    
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (node.child[cur-'a'] == null) {
                node.child[cur-'a'] = new TrieNode();
            }
            node = node.child[cur-'a'];
        }
        node.isEnd = true; 
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (node.child[cur-'a'] == null) {
                return false;
            }
            node = node.child[cur-'a'];
        }
        return node.isEnd; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);
            if (node.child[cur-'a'] == null) {
                return false;
            }
            node = node.child[cur-'a'];
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