class Trie {

    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++){            
            char ch = word.charAt(i);
            if (!parent.containsKey(ch)) {
                parent.put(new TrieNode(), ch);
            }
            parent = parent.get(ch);
        }
        parent.setIsEnd(true);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++){
            
            if (parent.containsKey(word.charAt(i))){
                if (!parent.getIsEnd()){
                    parent = parent.get(word.charAt(i));
                }
            }else {
                return false;
            }

        }
        if (!parent.getIsEnd()){
            return false;
        }
        return true;
        

    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode parent = root;
        for (int i = 0; i < prefix.length(); i++){
            
            if (parent.containsKey(prefix.charAt(i))){
                if (!parent.getIsEnd()){
                    parent = parent.get(prefix.charAt(i));
                }
            }else {
                return false;
            }

        }

        return true;
    }

    public class TrieNode{
        
        TrieNode[] links;

        final int R = 26;

        private boolean isEnd;

        public TrieNode(){
            links = new TrieNode[26];
        }

        public boolean containsKey(char ch){
            if (links[ch - 'a'] == null){
                return false;
            }
            return true;
        }

        public TrieNode get(char ch){
            return links[ch - 'a'];
        }


        public void put(TrieNode node, char ch){
            int index = ch - 'a';
            links[index] = node;
        }
        public void setIsEnd(boolean isEnd){
            this.isEnd = isEnd;
        }

        public boolean getIsEnd(){
            return this.isEnd;
        }

        


    }

}