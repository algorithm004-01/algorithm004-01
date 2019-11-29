/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-20 06:23
 **/

public class Leetcode_37_371 {

    /**
     * 仿解1:回溯
     *
     * @author Shaobo.Qian
     * @date 2019/11/20
     * @link https://leetcode-cn.com/problems/sudoku-solver/solution/hui-su-fa-jie-shu-du-by-i_use_python/
     */
    public void solveSudoku(char[][] board) {
        // 1.标记 行,列,小数独中的数字是否被使用过(用来剪枝)
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];
        //2.初始化
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int num = board[row][col] - '0';
                if (num >= 1 && num <= 9) {
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row / 3][col / 3][num] = true;
                }
            }
        }
        //3.回溯
        backtrace(rowUsed, colUsed, boxUsed, board, 0, 0);
    }

    private boolean backtrace(boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed, char[][] board, int row, int col) {
        //1.terminator
        if (col == board[0].length) {
            col = 0;
            row++;
            if (row == board.length) {
                return true;
            }
        }

        //2.current level
        if (board[row][col] == '.') {
            //尝试填充1-9
            for (int num = 1; num <= 9; num++) {
                boolean canUsed = !(rowUsed[row][num] || colUsed[col][num] || boxUsed[row/3][col/3][num]);
                if (canUsed) {
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row/3][col/3][num] = true;
                    //填充
                    board[row][col] = (char) ('0' + num);
                    //3.drill down
                    if (backtrace(rowUsed, colUsed, boxUsed, board, row, col + 1)) {
                        return true;
                    }
                    //4.restore status
                    board[row][col] = '.';
                    rowUsed[row][num] = false;
                    colUsed[col][num] = false;
                    boxUsed[row / 3][col / 3][num] = false;

                }
            }
        } else {
            return backtrace(rowUsed, colUsed, boxUsed, board, row, col + 1);
        }
        return false;
    }
}
