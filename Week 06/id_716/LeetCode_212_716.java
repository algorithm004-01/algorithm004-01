import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LeetCode_212_716 {
    private int rows;
    private int cols;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        rows = board.length;
        cols = rows > 0 ? board[0].length : 0;

        // 将 words 构建一个 Trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        // dfs
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dfs(board, trie, row, col, res, "");
            }
        }

        return new LinkedList<>(res);
    }

    private void dfs(char[][] board, Trie trie, int row, int col, Set<String> res, String s) {
        // terminator
        if (row < 0 || row >= rows || col < 0 || col >= cols) return;

        String ss = s + board[row][col];
        if (!trie.startsWith(ss)) return;
        if (trie.search(ss)) {
            res.add(ss);
        }

        board[row][col] ^= 256;

        // drill down
        for (int i = 0; i < dx.length; i++) {
            // if (row + dx[i] >= 0 && row + dx[i] < rows && col + dy[i] >= 0 && col + dy[i] < cols)
            dfs(board, trie, row + dx[i], col + dy[i], res, ss);
        }

        board[row][col] ^= 256;
    }

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