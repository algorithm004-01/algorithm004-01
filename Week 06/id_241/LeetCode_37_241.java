import java.util.*;
/**
 * 解数独
 */
class Solution {
    private Character[][] column = new Character[9][9];
    private Character[][] sub = new Character[9][9];
    private Character[][] row = new Character[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                int subNum = (i / 3) * 3 + j / 3;
                if (num != '.') {
                    row[i][num - 49] = num;
                    column[j][num - 49] = num;
                    sub[subNum][num - 49] = num;
                }
            }
        }
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') {
                    int subNum = (i / 3) * 3 + j / 3;
                    for (char k = '1'; k <= '9'; k++) {
                        if (row[i][k - 49] != null || column[j][k - 49] != null || sub[subNum][k - 49] != null)
                            continue;
                        board[i][j] = k;
                        row[i][k - 49] = k;
                        column[j][k - 49] = k;
                        sub[subNum][k - 49] = k;
                        if (solveSudokuHelper(board)) return true;
                        else {
                            row[i][k - 49] = null;
                            column[j][k - 49] = null;
                            sub[subNum][k - 49] = null;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}