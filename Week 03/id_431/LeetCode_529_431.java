package medium;

/**
 * @author 潘磊明
 * @date 2019/11/4
 */
public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        // 如果点到雷就返回
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        // 否则进行遍历
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int i, int j){
        int width = board.length;
        int height = board[0].length;
        if (i < 0 || i > width - 1 || j < 0 || j > height - 1 || board[i][j] != 'E') return;
        // 周围没有雷就进行深度遍历
        if (!surrentMine(board, i, j, width, height)) {
            dfs(board, i - 1, j - 1);
            dfs(board, i - 1, j);
            dfs(board, i - 1, j + 1);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
            dfs(board, i + 1, j - 1);
            dfs(board, i + 1, j);
            dfs(board, i + 1, j + 1);
        }
    }

    /**
     * 判断周围是否有雷
     * @param board
     * @param i
     * @param j
     * @return
     */
    private boolean surrentMine(char[][] board, int i, int j, int width, int height) {
        int count = 48; // 周围地雷数量
        if (i - 1 > -1 && j - 1 > -1 && board[i - 1][j - 1] == 'M') count++;
        if (i - 1 > -1 && board[i - 1][j] == 'M') count++;
        if (i - 1 > -1 && j + 1 < height && board[i - 1][j + 1] == 'M') count++;
        if (j - 1 > -1 && board[i][j - 1] == 'M') count++;
        if (i + 1 < width && j - 1 > -1 && board[i + 1][j - 1] == 'M') count++;
        if (j + 1 < height && board[i][j + 1] == 'M') count++;
        if (i + 1 <width && j + 1 < height && board[i + 1][j + 1] == 'M') count++;
        if (i + 1 < width && board[i + 1][j] == 'M') count++;
        if (count > 48) {
            board[i][j] = (char)count;
            return true;
        } else {
            board[i][j] = 'B';
            return false;
        }
    }
}
