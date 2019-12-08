package com.mrglint.leetcode.week06.solution36;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2019-11-23 07:32
 */
public class Solution {

    /**
     * 1. 遍历整个矩阵
     * 2. 根据矩阵中元素的坐标，计算出子数独的索引：假设坐标位(i, j)，矩阵为rows * cols，子数独索引计算公式：(i / 3) * 3 + j / 3
     *
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        List<Map<Character, Integer>> rows = new ArrayList<>();
        List<Map<Character, Integer>> cols = new ArrayList<>();
        List<Map<Character, Integer>> subSudokus = new ArrayList<>();

        // 初始化
        for (int i = 0; i < 9; i++) {
            rows.add(new HashMap<>());
            cols.add(new HashMap<>());
            subSudokus.add(new HashMap<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    Map<Character, Integer> rowsMap = rows.get(i);
                    Map<Character, Integer> colsMap = cols.get(j);
                    Map<Character, Integer> subSudokusMap = subSudokus.get(subSudokuIndex(i, j));
                    if (inValidate(rowsMap, i, j, board) || inValidate(colsMap, i, j, board) || inValidate(subSudokusMap, i, j, board)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private int subSudokuIndex(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }

    private boolean inValidate(Map<Character, Integer> map, int row, int col, char[][] board) {
        // 如果不存在返回-1
        Integer count = map.getOrDefault(board[row][col], -1);
        // 当前行、列、子数独未包含该字符
        if (count == -1) {
            map.put(board[row][col], 1);
            return false;
        } else {
            // 当前行、列、子数独未包含该字符
            return true;
        }
    }

}

