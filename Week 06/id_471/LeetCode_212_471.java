class Solution {
    Set<String> set = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
    
        Trie tree = new Trie();
        Set<String> set = new HashSet<>();
        boolean visited[][] = new boolean[board.length][board[0].length];
        List<String> results = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            tree.insert(words[i]);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                visited[i][j] = true;
                dfs(i, j, board[i][j] + "", visited, tree, results, board);
                visited[i][j] = false;
            }
        }

        return results;
    }

    public void dfs(int i, int j, String result, boolean[][] visited, Trie tree, List<String> results,char[][] board) {
        //System.out.println(result);
        if (!tree.isPrefix(result)) {
            return;
        }

        if (tree.search(result) && !set.contains(result)) {
            results.add(result);
            set.add(result);
            //return;
        }

        int step[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int k = 0; k < step.length; k++) {
            int x = i + step[k][0];
            int y = j + step[k][1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && !visited[x][y]) {
                visited[x][y] = true;
                dfs(x, y, result + board[x][y], visited, tree, results, board);
                visited[x][y] = false;
            }
            
        }
    }
    
    public class Trie{
        private TrieNode trie;

        public Trie() {
            trie = new TrieNode();
        }
        public void insert(String word) {
            TrieNode node = trie;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.getNode(ch);
            }
            node.setEnd();
        }

        public boolean search(String word) {
            TrieNode node = trie;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.getNode(ch);
            }
            return node.isEnd();
        }

        public boolean isPrefix(String word) {
            TrieNode node = trie;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.getNode(ch);
            }
            return true;
        }

        private class TrieNode{
            private TrieNode links[];
            boolean isEnd;
            private final int R = 26;

            public TrieNode() {
                links = new TrieNode[R];
            }

            public boolean containsKey(char ch) {
                return links[ch - 'a'] != null;
            }

            public void put(char ch, TrieNode node) {
                links[ch - 'a'] = node;
            }

            public TrieNode getNode(char ch) {
                return links[ch - 'a'];
            }

            public void setEnd() {
                isEnd = true;
            }

            public boolean isEnd() {
                return isEnd;
            }
        }
    }
}