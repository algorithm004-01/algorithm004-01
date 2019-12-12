package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/11/22
 */
public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int length = board.length;
        int height = board[0].length;
        TrieNode root = buildTrie(words);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                dfs(result, board, root, i, j);
            }
        }
        return result;
    }

    /**
     * dfs对源数据进行遍历
     * @param result
     * @param board
     * @param node
     * @param i
     * @param j
     */
    private void dfs(List<String> result, char[][] board, TrieNode node, int i, int j) {
        int length = board.length;
        int height = board[0].length;
        char visited = '#';
        //超出边界或者已经访问过就直接返回
        if (i < 0 || i > length - 1 || j < 0 || j > height - 1 || board[i][j] == visited || node.children[board[i][j] - 'a'] == null) return;
        char tmpChar = board[i][j];
        if (node.children[tmpChar - 'a'].word != null) {
            result.add(node.children[tmpChar - 'a'].word);
            node.children[tmpChar - 'a'].word = null; //去重
        }
        board[i][j] = visited;
        dfs(result, board, node.children[tmpChar - 'a'], i + 1, j);
        dfs(result, board, node.children[tmpChar - 'a'], i - 1, j);
        dfs(result, board, node.children[tmpChar - 'a'], i, j + 1);
        dfs(result, board, node.children[tmpChar - 'a'], i, j - 1);
        board[i][j] = tmpChar;
    }

    /**
     * 构建字典树
     * @param words
     * @return
     */
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String str : words) {
            TrieNode tmp = root;
            for (char c : str.toCharArray()) {
                if (tmp.children[c - 'a'] == null) tmp.children[c -'a'] = new TrieNode();
                tmp = tmp.children[c - 'a'];
            }
            tmp.word = str;
        }
        return root;
    }

    /**
     * 定义字典树
     */
    private class TrieNode {
        private TrieNode[] children;
        private String word;

        TrieNode() {
            children = new TrieNode[26];
        }
    }
}
