class Trie {

    private TrieNode[] root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word != null && word.length() > 0) {
            TrieNode[] temp = root;
            for(int i = 0; i < word.length(); i++) {
                int tempIndex = word.charAt(i) - 'a';
                TrieNode tempNode = temp[tempIndex];
                if(tempNode == null) {
                    tempNode = new TrieNode();
                    tempNode.value = word.charAt(i);
                    temp[tempIndex] = tempNode;
                } 

                if(i == word.length() - 1) {
                    tempNode.isWord = true;
                }
                temp = temp[tempIndex].next;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word != null && word.length() > 0) {
            TrieNode[] temp = root;
            for(int i = 0; i < word.length(); i++) {
                int tempIndex = word.charAt(i) - 'a';
                if(temp[tempIndex] == null) {
                    return false;
                } else {
                    if(i == word.length() - 1) {
                        if(temp[tempIndex].isWord) {
                            return true;
                        } else {
                            return false;
                        }
                    } 
                    temp = temp[tempIndex].next;
                }
            }
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix != null && prefix.length() > 0) {
            TrieNode[] temp = root;
            for(int i = 0; i < prefix.length(); i++) {
                int tempIndex = prefix.charAt(i) - 'a';
                if(temp[tempIndex] == null) {
                    return false;
                } else {
                    if(i == prefix.length() - 1) {
                        return true;
                    } 
                    temp = temp[tempIndex].next;
                }
            }
        }
        return false;
    }

    class TrieNode {
        public boolean isWord;
        public char value;
        public TrieNode[] next = new TrieNode[26];
    }
}
