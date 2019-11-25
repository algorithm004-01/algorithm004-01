class Trie {

    class TrieNode {
        private int v;
        boolean end;
        TrieNode[] next = new TrieNode[26];

        TrieNode(char ch) {
            v = 1 << (ch - 'a');
        }

        TrieNode add(char ch) {
            int k = ch - 'a';
            if (next[k] != null) {
                next[k].v |= 1 << k;
            } else {
                next[k] = new TrieNode((ch));
            }
            return next[k];
        }

        TrieNode get(char ch) {
            return next[ch - 'a'];
        }
    }

    TrieNode root = new TrieNode('a');

    /**
        * Initialize your data structure here.
        */
    public Trie() {}

    /**
        * Inserts a word into the trie.
        */
    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            p = p.add(c);
        }
        p.end = true;
    }

    /**
        * Returns if the word is in the trie.
        */
    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            p = p.get(c);
            if (p == null) {
                return false;
            }
        }
        return p.end;
    }

    /**
        * Returns if there is any word in the trie that starts with the given prefix.
        */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            p = p.get(c);
            if (p == null) {
                return false;
            }
        }
        return true;
    }
}
