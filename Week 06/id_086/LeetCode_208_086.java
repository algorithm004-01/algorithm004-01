class TrieNode {
    TrieNode[] child;
    boolean is_end;
    public TrieNode() {
        child = new TrieNode[26];
        is_end = false;
    }

}

public class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ptr = root;
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (ptr.child[c-'a'] == null) {
               ptr.child[c-'a'] = new TrieNode();
            }
            ptr = ptr.child[c-'a'];
        }
        ptr.is_end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ptr = root;
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(ptr.child[c-'a'] == null) {
                return false;
            }
            ptr = ptr.child[c-'a'];
        }
        return ptr.is_end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(ptr.child[c-'a']==null){
                return false;
            }
            ptr = ptr.child[c-'a'];
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