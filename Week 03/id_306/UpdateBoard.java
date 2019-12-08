/**
 * Created by LynnSun on 2019/10/30.
 * 力扣题目地址：https://leetcode-cn.com/problems/minesweeper/description/
 */
public class UpdateBoard {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (click[0] < 0 || click[1] < 0) return board;
        if (click[0] >= board.length || click[1] >= board[0].length) return board;

        int row, col;
        row = click[0];
        col = click[1];

        // Hit a blank, skip
        if (board[row][col] == 'B') {
            return board;
        }

        // Hit a mine, game over
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        // Check for surrounding mines
        int mines = checkAdjacent(board, click);
        if (mines != 0) {
            board[row][col] = (char) (mines + '0');
            return board;
        }

        // Totally blank
        board[row][col] = 'B';
        // Update all surrounding tiles
        for (int i = row-1; i <= row+1; i++) {
            for (int j = col-1; j <= col+1; j++) {
                board = updateBoard(board, new int[]{i, j});
            }
        }

        return board;
    }

    private int checkAdjacent(char[][] board, int[] tile) {
        int total = 0;
        int iMin, iMax, jMin, jMax;
        iMin = jMin = 0;
        iMax = board.length - 1;
        jMax = board[0].length - 1;

        // Start with top left surrounding tile
        int startI = tile[0] - 1;
        int startJ = tile[1] - 1;
        for (int i = startI; i <= startI + 2; i++) {
            // skip out of bound indices
            if (i < iMin) continue;
            if (i > iMax) continue;

            for (int j = startJ; j <= startJ + 2; j++) {
                // skip out of bound indices
                if (j < jMin) continue;
                if (j > jMax) continue;

                // Add all adjacent mines to the list
                if (board[i][j] == 'M') {
                    total++;
                }
            }
        }

        return total;
    }
}
