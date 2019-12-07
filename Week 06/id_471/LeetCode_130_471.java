class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] == 'O' ? 'X' : board[i][j] == 'X' ? 'X' : 'O';
            }
        }
    }
    
    public void dfs(char[][] board, int x, int y) {
        board[x][y] = '@';
        int[][] step = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for (int i = 0; i < step.length; i++) {
            int tempX = x + step[i][0];
            int tempY = y + step[i][1];
            
            if (tempX >= 0 && tempX < board.length && tempY >= 0 && tempY < board[tempX].length && board[tempX][tempY] == 'O') {
                dfs(board, tempX, tempY);
            }
        }
    }
}