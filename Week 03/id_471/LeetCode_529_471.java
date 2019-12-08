class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        
        dfs(x, y, board);
        
        return board;
    }
    
    public void dfs(int x, int y, char[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] != 'E') {
            return;
        }
        
        int num = findMines(x, y, board);
        if (num != 0) { 
            board[x][y] = (char)('0'+num);
            return;
            
        }
        
        board[x][y] = 'B';
        
        int path[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0; i < path.length; i++) {
            dfs(x + path[i][0], y + path[i][1], board);
        }
    }
    
    public int findMines(int x, int y, char[][] board) {
        int num = 0;
        int tempx = x;
        int tempy = y;
        int path[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0; i < path.length; i++) {
            x = tempx + path[i][0];
            y = tempy + path[i][1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && board[x][y] == 'M') {
                num++;
            }
        }
        return num;
    }
}