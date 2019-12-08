
public class LeetCode_208_416{

    public class TrieNode{
        TrieNode[] child = new TrieNode[26];
        String word;
    }
    public TrieNode insert(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode p = root;
            for(int i = 0;i < word.length();i++) {
                char c = word.charAt(i);
                if(p.child[c - 'a'] == null) {
                    p.child[c - 'a'] = new TrieNode();
                }
                p = p.child[c - 'a'];
            }
            p.word = word;
        }
        return root;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        TrieNode root = insert(words);
        for(int i = 0;i < board.length;i++) {
            for(int j = 0; j <board[0].length;j++) {
                dfs(board,i,j,root,res);
            }
        }
        return res;
    }
    public void dfs(char[][] board, int i, int j,TrieNode p ,List<String> res) {
        //terminator
        //current process logic
        //drill down
        char c = board[i][j];
        if(c == '#' || p.child[c - 'a'] == null) return;
        p = p.child[c - 'a'];
        if(p.word != null) {
            res.add(p.word);
            p.word = null;
        }
        board[i][j] = '#';
        if(i > 0 ) dfs(board,i - 1,j,p,res);
        if(j > 0 ) dfs(board,i,j - 1,p,res);
        if(i < board.length - 1) dfs(board,i + 1,j,p,res);
        if(j < board[0].length - 1) dfs(board,i , j + 1,p,res);
        board[i][j] = c;
    }

}