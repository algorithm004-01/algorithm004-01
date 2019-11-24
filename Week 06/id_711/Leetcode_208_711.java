package Week6;

//class TrieNode {
//    private TrieNode[] links;
//
//    private final int R = 26;
//
//    private boolean isEnd;
//
//    public TrieNode() {
//        links = new TrieNode[R];
//    }
//
//    public boolean containKey(char ch) {
//        return links[ch - 'a'] != null;
//    }
//
//    public TrieNode get(char ch) {
//        return links[ch - 'a'];
//    }
//
//    public void put(char ch, TrieNode node) {
//        links[ch - 'a'] = node;
//    }
//
//    public void setEnd() {
//        isEnd = true;
//    }
//
//    public boolean isEnd() {
//        return isEnd;
//    }
//}
//
//class Trie {
//
//    private TrieNode root;
//
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    public void insert(String word) {
//        TrieNode node = root;
//        for (int i = 0; i < word.length(); i++) {
//            char currentChar = word.charAt(i);
//            if (!node.containKey(currentChar)) {
//                node.put(currentChar, new TrieNode());
//            }
//            node = node.get(currentChar);
//        }
//        node.setEnd();
//    }
//
//    private TrieNode searchPrefix(String word) {
//        TrieNode node = root;
//        for (int i = 0; i < word.length(); i++) {
//            char currentChar = word.charAt(i);
//            if (!node.containKey(currentChar))
//                return null;
//            node = node.get(currentChar);
//        }
//        return node;
//    }
//
//    public boolean search(String word) {
//        TrieNode node = searchPrefix(word);
//        return node != null && node.isEnd();
//    }
//
////
////    TrieNode node = root;
////        for (int i = 0; i < word.length(); i++) {
////        char currentChar = word.charAt(i);
////        if (!node.containKey(currentChar))
////            return false;
////        node = node.get(currentChar);
////    }
////        return node.isEnd();
//
//    public boolean startsWith(String prefix) {
//        return searchPrefix(prefix) != null;
//    }
//}

public class Leetcode_208_711 {
    public static void main(String[] args) {
//        Trie trie = new Trie();
//        trie.insert("asia");
//        trie.insert("asiawyz");
//        trie.insert("today");
//        System.out.println(trie.search("asia"));
//        System.out.println(trie.startsWith("asdf"));
    }
}
