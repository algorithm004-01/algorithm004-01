class Solution {
    
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        } else {
            // 深度优先搜索
            dfs(board, click[0], click[1]);
        }

        return board;
    }

    private void dfs(char[][] board, int row, int column) {
        int m = 0;
        boolean hasB = false;
        for(int j = - 1; j <= 1; j++){
            for(int k = - 1; k <= 1; k++){
                if(row + j >= 0 && row + j < board.length 
                    && column + k >= 0 && column + k < board[0].length) {
                    if(board[row + j][column + k] == 'M') {
                        m++;
                    } 

                    if(board[row + j][column + k] == 'B'){
                        hasB = true;
                    }
                }
            }
        }

        if(m > 0){
            board[row][column] = (char) ( m + '0');
        } else {
            board[row][column] = 'B'; 
            for(int j = - 1; j <= 1; j++){
                for(int k = - 1; k <= 1; k++){
                    if(row + j >= 0 && row + j < board.length 
                        && column + k >= 0 && column + k < board[0].length) {
                        if(board[row + j][column + k] == 'E') {
                            dfs(board, row + j, column + k);
                        } 
                    }
                }
            }
        }

        
    }
}
