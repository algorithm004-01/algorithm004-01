package com.uanei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_51_286 {

    /**
     * 什么情况下能被攻击，同一行同一列，撇捺
     */
    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // 处理
        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        // 所有的列都判断了，返回棋盘
        if (colIndex == board.length) {
            res.add(construct(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            // 如果验证通过，皇后放上去
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                // 下一列
                dfs(board, colIndex + 1, res);
                // 清理状态
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                // 从头遍历，第i行和第j列存在皇后
                // 判断撇 左对角线
                // 判断捺 右对角线
                // 判断是否在相同的列
                if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 格式化棋盘到返回结果
     */
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


}
