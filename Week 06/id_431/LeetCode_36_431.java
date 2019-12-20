package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/11/27
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                String row = "row_" + i + "_" + board[i][j];
                if (set.contains(row)) return false;
                else set.add(row);
                String col = "col_" + j + "_" + board[i][j];
                if (set.contains(col)) return false;
                else set.add(col);
                String cell = "cell_" + (i / 3) + "_" + (j / 3) + "_" + board[i][j];
                if (set.contains(cell)) return false;
                else set.add(cell);
            }
        }
        return true;
    }
}
