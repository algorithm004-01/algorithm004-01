import java.util.*;
/**
 * 单词搜索 II
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> result = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                findWordsHelper(i, j, trie, result, "", board, m, n);
        return new ArrayList<>(result);
    }

    private void findWordsHelper(int i, int j, Trie trie, HashSet<String> result, String s, char[][] board, int ml, int nl) {
        if (i < 0 || i > ml - 1 || j < 0 || j > nl - 1 || board[i][j] == '#') return;
        s += board[i][j];
        trie = trie.node[board[i][j] - 'a'];
        if (trie == null) return;
        if (trie.isEnd) result.add(s);
        int[] m = new int[]{-1, 1, 0, 0}, n = new int[]{0, 0, -1, 1};
        for (int c = 0; c < 4; c++) {
            char tmp = board[i][j];
            board[i][j] = '#';
            findWordsHelper(i + m[c], j + n[c], trie, result, s, board, ml, nl);
            board[i][j] = tmp;
        }
    }

    static class Trie {

        private Trie[] node;
        private boolean isEnd;

        public Trie() {
            this.node = new Trie[26];
        }

        public void insert(String word) {
            Trie curr = this;
            for (char w : word.toCharArray()) {
                if (curr.node[w - 'a'] == null) curr.node[w - 'a'] = new Trie();
                curr = curr.node[w - 'a'];
            }
            curr.isEnd = true;
        }

    }
}