import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Leetcode_212 {
    public List<String> finidWords(char[][] board, String[] words) {
        Trie wordTrie = new Trie();
        for (String s : words) wordTrie.insert(s);
        TrieNode root = wordTrie.root;
        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] marked = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                find(board, marked, i, j, m, n, root, result);
            }
        }
        return new LinkedList<String>(result);
    }

    private void find(char[][] board,
                      boolean[][] marked,
                      int i, int j,
                      int m, int n,
                      TrieNode cur,
                      Set<String> res) {
        //termination
        if (i < 0 || i == m || j < 0 || j == n || marked[i][j]) return;
        //proccess
        cur = cur.child[board[i][j] - 'a'];
        marked[i][j] = true;
        if (cur == null) {
            marked[i][j] = false;
            return;
        }
        if (cur.isWord) res.add(new String(cur.val));
        //drill down
        find(board, marked, i + 1, j, m, n, cur, res);
        find(board, marked, i - 1, j, m, n, cur, res);
        find(board, marked, i, j + 1, m, n, cur, res);
        find(board, marked, i, j - 1, m, n, cur, res);
        //reverse
        marked[i][j] = false;
    }

    //字典树
    class Trie {
        public TrieNode root;
        public Trie() { root = new TrieNode(); }
        public void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.child[c - 'a'] == null) cur.child[c - 'a'] = new TrieNode();
                    cur = cur.child[c - 'a'];
            }
            cur.isWord = true;
            cur.val = s;
        }
    }

    //字典树结点
    class TrieNode {
        public String val;
        public TrieNode[] child = new TrieNode[26];
        public boolean isWord = false;
    }
}
