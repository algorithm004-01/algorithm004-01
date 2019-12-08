class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        WorkTried workTried = new WorkTried();
        for(String word : words){
            workTried.insert(word);
        }
        int n = board.length;
        int m = board[0].length;
        boolean[][] visit = new boolean[n][m];
        HashSet<String> result = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                search(i, j, n, m, visit, board, workTried.root, result);
            }
        }
        return new ArrayList(result);
    }
    public void search(int i, int j, int n, int m, boolean[][] visit, char[][] board, TriedNode root, HashSet<String> result){
        if(i >= n || j >= m || i < 0 || j < 0 || visit[i][j]){
            return;
        }
        visit[i][j] = true;
        root = root.child[ board[i][j] - 'a'];
        if(root == null){
            visit[i][j] = false;
            return;
        }
        if(root.isLeaf){
            result.add(root.val);
        }
        search(i + 1, j, n, m, visit, board, root, result);
        search(i, j + 1, n, m, visit, board, root, result);
        search(i, j - 1, n, m, visit, board, root, result);
        search(i - 1, j, n, m, visit, board, root, result);
        visit[i][j] = false;

    }
}
class WorkTried{
    TriedNode root = new TriedNode();
    public void insert(String s){
        TriedNode cur = root;
        for(int i = 0; i < s.length(); i++){
            if(cur.child[s.charAt(i) - 'a'] == null){
                cur.child[s.charAt(i) - 'a'] = new TriedNode();
                cur = cur.child[s.charAt(i) - 'a'];
            } else {
                cur = cur.child[s.charAt(i) - 'a'];
            }
        }
        cur.isLeaf = true;
        cur.val = s;
    }
}
class TriedNode{
    String val;
    boolean isLeaf;
    TriedNode[] child = new TriedNode[26];
}