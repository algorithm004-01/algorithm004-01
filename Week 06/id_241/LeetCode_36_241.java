import java.util.*;
/**
 * 有效的数独
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Character[][] column = new Character[9][9];
        Character[][] sub = new Character[9][9];
        Character[] row = new Character[9];
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                if (row[num - 49] == null) row[num - 49] = num;
                else return false;
                if (column[j][num - 49] == null) column[j][num - 49] = num;
                else return false;
                int subNum = (i / 3) * 3 + j / 3;
                if (sub[subNum][num - 49] == null) sub[subNum][num - 49] = num;
                else return false;
            }
            row = new Character[9];
        }
        return true;
    }
}