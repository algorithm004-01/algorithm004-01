import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-19 10:12
 **/

public class Leetcode_212_371 {
    public static void main(String[] args) {

    }
    class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        String word;
    }

    /**
     * 仿解1:字典树+回溯(剪枝)
     *
     * @author Shaobo.Qian
     * @date 2019/11/19
     * @link https://leetcode.com/problems/word-search-ii/discuss/59784/My-simple-and-clean-Java-code-using-DFS-and-Trie
     * @link https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode currNode, List<String> res) {
        //1.terminator
        if ( i < 0 || i < j || i >= board.length || j >= board[0].length) return;
        //2.处理当前层逻辑
        char c = board[i][j];
        if(c == '#' || currNode.children[c - 'a'] == null) return;
        currNode = currNode.children[c - 'a'];
        if (currNode.word != null) {
            res.add(currNode.word);
            currNode.word = null;//since we have visited this leaf node, then set "word" null , make sure we do not visit it once again.
        }

        board[i][j] = '#'; //将当前位置标记为已访问
        //3.drill down
        dfs(board, i - 1, j, currNode, res);
        dfs(board, i, j - 1, currNode, res);
        dfs(board, i + 1, j, currNode, res);
        dfs(board, i, j + 1, currNode, res);

        //4.还原状态
        board[i][j] = c;

    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode currNode = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (currNode.children[index] == null) currNode.children[index] = new TrieNode();
                currNode = currNode.children[index];
            }
            currNode.word = word;
        }
        return root;
    }
}
