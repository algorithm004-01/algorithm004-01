package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/11/27
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        int[][] row = new int[9][10]; //当前行上已出现的数字
        int[][] col = new int[9][10]; //当前列上已出现的数字
        int[][] cell = new int[9][10]; //当前单元格中出现的数字
        List<List<Integer>> empty = new ArrayList<>();
        //init初始化数据
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') empty.add(Arrays.asList(i, j));
                else {
                    int value = board[i][j] - '0';
                    row[i][value] = value;
                    col[j][value] = value;
                    cell[i / 3 * 3 + j / 3][value] = value;
                }
            }
        }
        dfs(board, empty, row, col, cell, 0);
    }

    private boolean dfs(char[][] board, List<List<Integer>> empty, int[][] row, int[][] col, int[][] cell, int i){
        if (i == empty.size()) return true;
        int r = empty.get(i).get(0);
        int c = empty.get(i).get(1);
        for (char j = '1'; j <= '9'; j++) {
            if (isValid(row, col, cell, j - '0', r, c)) {
                board[r][c] = j;
                int val = j - '0';
                row[r][val] = val;
                col[c][val] = val;
                cell[r / 3 * 3 + c / 3][val] = val;
                boolean flag = dfs(board, empty, row, col, cell, i + 1);
                if (flag) return true;
                //进行状态恢复
                board[r][c] = '.';
                row[r][val] = 0;
                col[c][val] = 0;
                cell[r / 3 * 3 + c / 3][val] = 0;
            }
        }
        return false;
    }

    /**
     * 验证数组是否合法
     * @param row
     * @param col
     * @param cell
     * @param val
     * @param i
     * @param j
     * @return
     */
    private boolean isValid(int[][] row, int[][] col, int[][] cell, int val, int i, int j) {
        return row[i][val] == 0 && col[j][val] == 0 && cell[i / 3 * 3 + j / 3][val] == 0;
    }
}
