package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 思路：
 * 1. 暴力循环：遍历每个words中的word，将word中的每个字符，拿到board中去进行4连通法则匹配，即匹配上下左右字符，看能否一直找到最后一个字符
 * 2. 利用字典树(Tires): 利用words构建字段树，再将board中的每个字符，按照4连通法则，去tries中去找单词，如果能找到单词，说明该单词在board中
 *
 * @date 2019/11/23 11:54 PM
 */
public class LeetCode_212_721 {

    private TrieNode root;

    public LeetCode_212_721() {
        root = new TrieNode();
    }

    public List<String> findWords(char[][] board, String[] words) {
        // build tries
        buildTries(words);
        int rows = board.length;
        int column = board[0].length;
        boolean[][] visited = new boolean[rows][column];
        Set<String> result = new HashSet<>();
        // 递归遍历每个字符的4连通字符，是否在目标搜索树中
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                TrieNode node = root;
                findRecur(board, visited, i, j, rows, column, result, node);
            }
        }
        return new LinkedList<>(result);
    }

    private void findRecur(char[][] board, boolean[][] visited, int i, int j, int rows, int column, Set<String> result, TrieNode cur) {
        // terminator
        if (i >= rows || j >= column || i < 0 || j < 0 || visited[i][j]) {
            return;
        }
        // process current level
        cur = cur.child[board[i][j] - 'a'];
        visited[i][j] = true;
        if (null == cur) {
            visited[i][j] = false;
            return;
        }
        if (cur.isLeaf) {
            result.add(cur.val);
        }

        // drill down
        findRecur(board, visited, i + 1, j, rows, column, result, cur);
        findRecur(board, visited, i, j + 1, rows, column, result, cur);
        findRecur(board, visited, i - 1, j, rows, column, result, cur);
        findRecur(board, visited, i, j - 1, rows, column, result, cur);
        // reset status 最后要回退，因为下一个起点可能会用到上一个起点的字符
        visited[i][j] = false;

    }

    private void buildTries(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.child[ch - 'a'] == null) {
                    node.child[ch - 'a'] = new TrieNode();
                }
                node = node.child[ch - 'a'];
            }
            node.isLeaf = true;
            node.val = word;

        }
    }

    class TrieNode {
        public String val;
        public TrieNode[] child = new TrieNode[26];
        public boolean isLeaf = false;

        TrieNode() {

        }
    }


}
