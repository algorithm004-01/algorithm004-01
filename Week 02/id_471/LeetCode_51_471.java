class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean visitCol[] = new boolean[n];
        boolean visitLine1[] = new boolean[2*n];
        boolean visitLine2[] = new boolean[2*n];
        List<String> board = new ArrayList<>();
        List<List<String>> results = new ArrayList<>();
        dfs(0, n, board, results, visitCol, visitLine1, visitLine2);
        return results;
    }
    
    public void dfs(int row, int n, List<String> board, List<List<String>> results, boolean visitCol[], boolean visitLine1[], boolean visitLine2[]){
        //terminator
        if(row == n){
            results.add(new ArrayList<>(board));
            return;
        }
        
        //process data
        for(int col = 0; col < n; col++){
            int id1 = col - row + n;
            int id2 = row + col;
            
            if(!visitCol[col] && !visitLine1[id1] && !visitLine2[id2]){
                visitCol[col] = true;
                visitLine1[id1] = true;
                visitLine2[id2] = true;
                char temp[] = new char[n];
                Arrays.fill(temp, '.');
                temp[col] = 'Q';
                String queen = new String(temp);
                board.add(queen);
                //drill down
                dfs(row + 1, n, board, results, visitCol, visitLine1, visitLine2);
                //reverse state
                visitCol[col] = false;
                visitLine1[id1] = false;
                visitLine2[id2] = false;
                board.remove(board.size() - 1);
            }
        }
    }
}