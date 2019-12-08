class Solution {
    //思路1
    //进行合理减支，比较好理解
    private List<List<String>> queenPlacement = null;
    public List<List<String>> solveNQueens(int n) {
        queenPlacement = new ArrayList<>();
        List<String> plaments = new ArrayList<>();
        String rowFill = "";
        for (int i = 0; i < n; ++ i) rowFill += '.';
        for (int i = 0; i < n; ++ i) plaments.add(rowFill);
        
        placeQueens(n, 0, plaments);
        return queenPlacement;
    }

    private void placeQueens(int n, int row, List<String> plaments) {
        //termination
        if (row == n) {
            queenPlacement.add(new ArrayList<>(plaments));
            return;
        }
        
        //process
        String preRow = plaments.get(row);
        for (int col = 0; col < n; ++ col) {
            String newRow = preRow.substring(0,col)+'Q'+preRow.substring(col+1);
            plaments.set(row, newRow);
            if (isValid(row, col, plaments))placeQueens(n, row+1, plaments);
            plaments.set(row, preRow);
        }
    }

    private boolean isValid(int row, int col, List<String> plaments) {
        for (int i = 0; i < row; ++ i) {
            int diff = Math.abs(col - plaments.get(i).indexOf('Q'));
            if ( diff == 0 || row -i == diff) return false;
        }
        return true;
    }

}