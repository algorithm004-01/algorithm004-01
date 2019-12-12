class TrieNode{
    private TrieNode[] linked;
    private int R = 26;
    private boolean isEnd;
    public TrieNode(){
        linked = new TrieNode[R];
    }
    public boolean containsKey(char ch){
        return linked[ch - 'a'] != null;
    }
    public void put(char ch){
        linked[ch - 'a'] = new TrieNode();
    }
    public TrieNode get(char ch){
        return linked[ch - 'a'];
    }
    public void setEnd(){
        this.isEnd = true;
    }
    public boolean getEnd(){
        return isEnd;
    }

}
class Trie {
    private TrieNode rootNode;
    /** Initialize your data structure here. */
    public Trie() {
        rootNode = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = rootNode;
        for(int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)){
                node.put(currentChar);
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = rootNode;
        for(int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)){
                node = node.get(currentChar);
            }else{
                node = null;
                break;
            }
        }
        return node != null && node.getEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = rootNode;
        for(int i = 0; i < prefix.length(); i++){
            char currentChar = prefix.charAt(i);
            if (node.containsKey(currentChar)){
                node = node.get(currentChar);
            }else{
                node = null;
                break;
            }
        }
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */