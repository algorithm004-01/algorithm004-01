class Trie {

     Initialize your data structure here. 
    private TrieNode trie;
    public Trie() {
        trie = new TrieNode();
    }
    
     Inserts a word into the trie. 
    public void insert(String word) {
        TrieNode temp = trie;
        for (int i = 0; i  word.length(); i++) {
            if(!temp.containsKey(word.charAt(i))) {
                TrieNode node = new TrieNode();
                temp.put(word.charAt(i), node);
            }
            temp = temp.links[word.charAt(i) - 'a'];
        }

        temp.setEnd();
    }
    
     Returns if the word is in the trie. 
    public boolean search(String word) {
        TrieNode temp = trie;

        for (int i = 0; i  word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.containsKey(ch)) {
                return false;
            }

            temp = temp.get(ch);
        }
        return temp.isEnd();
    }
    
     Returns if there is any word in the trie that starts with the given prefix. 
    public boolean startsWith(String prefix) {
        TrieNode temp = trie;

        for (int i = 0; i  prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!temp.containsKey(ch)) {
                return false;
            }

            temp = temp.get(ch);
        }

        return true;
    }

    private class TrieNode{
        private TrieNode links[];
        private final int R = 26;
        boolean isEnd;

        public TrieNode() {
            links = new TrieNode[26];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}


  Your Trie object will be instantiated and called as such
  Trie obj = new Trie();
  obj.insert(word);
  boolean param_2 = obj.search(word);
  boolean param_3 = obj.startsWith(prefix);
 