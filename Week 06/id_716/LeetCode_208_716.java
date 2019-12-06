
public class LeetCode_208_716 {
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
    
            TrieNode p = root;
            for (Character c : word.toCharArray()) {
                if (!p.containsKey(c)) {
                    p.put(c, new TrieNode());
                }
                p = p.get(c);
            }
            p.setEnd();
    
        }
    
        private TrieNode searchPrefix(String word) {
            TrieNode p = root;
            for (Character c : word.toCharArray()) {
                if (!p.containsKey(c)) {
                    return null;
                }
    
                p = p.get(c);
            }
    
            return p;
        }
    
        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode p = searchPrefix(word);
            return p != null && p.isEnd();
        }
    
        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode p = searchPrefix(prefix);
            return p != null;
        }
    }

    class TrieNode {

        private TrieNode[] links;
        private final int R = 26;
    
        private boolean isEnd;
    
        public TrieNode() {
            links = new TrieNode[R];
        }
    
        public void setEnd() {
            isEnd = true;
        }
    
        public boolean isEnd() {
            return isEnd;
        }
    
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
    
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }
    
        public TrieNode get(int position) {
            return links[position];
        }
    
        public boolean containsKey(char ch) {
            if (ch < 'a' || ch > 'z') return false;
            return links[ch - 'a'] != null;
        }
    
        public boolean isEmpty() {
            for (TrieNode n : links) {
                if (n != null) {
                    return false;
                }
            }
    
            return true;
        }

    }

}