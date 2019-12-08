package Week6;

import java.util.LinkedList;
import java.util.List;

class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    public TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ws.children[ch - 'a'] == null) {
                ws.children[ch - 'a'] = new TrieNode(ch);
            }
            ws = ws.children[ch - 'a'];
        }
        ws.isWord = true;
    }

    public TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return null;
            }
            node = node.children[ch - 'a'];
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}

public class Leetcode_212_711 {
    public static void main(String[] args) {
        String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
        char[][] board = {
            {'a','b'},
            {'c','d'}
        };
        Leetcode_212_711 asia = new Leetcode_212_711();
        List<String> lis = asia.findWords(board, words);
        for (String st : lis) {
            System.out.println(st);
        }
    }



    public Trie tree;
    public List<String> list;
    public int[] a = {0,0,1,-1};
    public int[] b = {1,-1,0,0};
    public int n,m;
    public char[][] bo;

    /**
     * 先用字典树对所给的单词建树，然后对char数组进行dsf，利用字典树剪枝。
    * 执行用时 :27 ms, 在所有 java 提交中击败了69.77%的用户
     * 内存消耗 :47.3 MB, 在所有 java 提交中击败了88.51%的用户
     * @param board
     * @param words
     * @return
     */
    private List<String> findWords(char[][] board, String[] words) {
        tree = new Trie();
        for (String str : words) {
            tree.insert(str);
        }
        list = new LinkedList<>();
        n = board.length;
        m = board[0].length;
        bo = board;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i,j,"");
            }
        }
        return list;
    }

    private void dfs(int x, int y, String s) {
        String str = s + bo[x][y];
        TrieNode node = tree.searchPrefix(str);
        if (node == null)
            return;
        if (node.isWord) {
            list.add(str);
            node.isWord = false;
        }
        char tmp = bo[x][y];
        bo[x][y] = '#';
        for (int i = 0; i < 4; i++) {
            int x1 = x + a[i], y1 = y + b[i];
            if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m || bo[x1][y1] == '#')
                continue;
            dfs(x + a[i], y + b[i], str);
        }
        bo[x][y] = tmp;
    }
}
