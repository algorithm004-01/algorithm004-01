
public class LeetCode_208_416{
    TrieNode root = new TrieNode();
    public class TrieNode{
        TrieNode[] child;
        boolean is_end;
        public TrieNode() {
            child = new TrieNode[26];
            is_end = false;
        }
    }

    public void insert(String word) {
        TrieNode cNode = root;
        for(int i = 0;i < word.length();i++) {
            char c = word.charAt(i);
            if(cNode.child[c - 'a'] == null) {
                cNode.child[c - 'a'] = new TrieNode();
            }
            cNode = cNode.child[c - 'a'];
        }
        cNode.is_end = true;
    }
    public boolean search(String word) {
        TrieNode cNode = root;
        for(int i = 0;i < word.length();i++) {
            char c = word.charAt(i);
            if(cNode.child[c - 'a'] == null) {
                return false;
            }
            cNode = cNode.child[c - 'a'];
        }
        return cNode.is_end;
    }
    public boolean startsWith(String prefix) {
        TrieNode cNode = root;
        for(int i = 0;i < word.length();i++) {
            char c = word.charAt(i);
            if(cNode.child[c - 'a'] == null) {
                return false;
            }
            cNode = cNode.child[c - 'a'];
        }
        return true;
    }
}