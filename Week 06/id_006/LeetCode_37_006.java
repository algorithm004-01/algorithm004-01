package com.mrglint.leetcode.week06.solution37;

/**
 * @author luhuancheng
 * @since 2019-11-23 09:08
 */
public class Solution {

    public void solveSudoku(char[][] board) {

        boolean[][] rowsUsed = new boolean[9][10];
        boolean[][] colsUsed = new boolean[9][10];
        // 子数独
        boolean[][] subSudokusUsed = new boolean[9][10];

        // 初始化
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int placeNumber = board[i][j] - '0';
                    rowsUsed[i][placeNumber] = true;
                    colsUsed[j][placeNumber] = true;
                    // 根据坐标，计算所在的子数独索引
                    int subSudokuNum = subSudokuIndex(i, j);
                    subSudokusUsed[subSudokuNum][placeNumber] = true;
                }
            }
        }

        // 递归求解，遍历所有格子，为空格时，对1 - 9进行筛选（行、列、小区域不能重复）选取一个合适的数字填入格子中，进入下一个格子。
        // 如果下探到下一格子时无法求解，则回溯到下探前的格子
        // 直到遍历到最后一个格子
        solveSudoku(board, rowsUsed, colsUsed, subSudokusUsed);
    }

    private boolean solveSudoku(char[][] board, boolean[][] rowsUsed, boolean[][] colsUsed, boolean[][] subSudokusUsed) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int placeNumber = 1; placeNumber <= 9; placeNumber++) {
                        if (canPlace(i, j, rowsUsed, colsUsed, subSudokusUsed, placeNumber)) {
                            // 放置数字
                            board[i][j] = Character.forDigit(placeNumber, 10);
                            rowsUsed[i][placeNumber] = true;
                            colsUsed[j][placeNumber] = true;
                            subSudokusUsed[subSudokuIndex(i, j)][placeNumber] = true;
                            if (solveSudoku(board, rowsUsed, colsUsed, subSudokusUsed)) {
                                return true;
                            }
                            board[i][j] = '.';
                            rowsUsed[i][placeNumber] = false;
                            colsUsed[j][placeNumber] = false;
                            subSudokusUsed[subSudokuIndex(i, j)][placeNumber] = false;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private int subSudokuIndex(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }

    private boolean canPlace(int row, int col, boolean[][] rowsUsed, boolean[][] colsUsed, boolean[][] subSudokusUsed, int number) {
        return !rowsUsed[row][number] && !colsUsed[col][number] && !subSudokusUsed[subSudokuIndex(row, col)][number];
    }

}

