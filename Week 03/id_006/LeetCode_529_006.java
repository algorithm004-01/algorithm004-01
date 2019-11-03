package com.mrglint.leetcode.week03.solution529;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luhuancheng
 * @since 2019-11-03 14:10
 */
public class Solution {

    /**
     * 未挖出炸弹
     */
    private static final char BOMBSHELL = 'M';

    /**
     * 未挖出空地
     */
    private static final char NOT_TO_DIG_BLACK = 'E';

    /**
     * 安全区域
     */
    private static final char SAFE_AREA = 'B';

    /**
     * 爆炸区域
     */
    private static final char EXPLODE_AREA = 'X';

    /**
     * 周围八个位置的坐标偏移
     */
    private static final int[][] DIRECTIONS = new int[][]{{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};

    /**
     * 思路：广度优先搜索
     * 要点：当周围没有炸弹，则遍历周围节点；否则获取周围炸点节点，标记为数字
     *
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int clickRow = click[0];
        int clickCol = click[1];

        int rows = board.length;
        int cols = board[0].length;

        // 标记节点是否被访问
        boolean[][] visited = new boolean[rows][cols];

        // 点击到炸弹
        if (board[clickRow][clickCol] == BOMBSHELL) {
            board[clickRow][clickCol] = EXPLODE_AREA;
            return board;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        visited[clickRow][clickCol] = true;
        while (!queue.isEmpty()) {
            int[] queueHead = queue.poll();
            int row = queueHead[0];
            int col = queueHead[1];

            int number = getBombShellNumber(row, col, rows, cols, board);
            if (number == 0) {
                // 周围没有炸弹，标记为 'B'
                board[row][col] = SAFE_AREA;
                // 遍历八个相连节点
                for (int i = 0; i < DIRECTIONS.length; i++) {
                    int newRow = row + DIRECTIONS[i][0];
                    int newCol = col + DIRECTIONS[i][1];
                    // 不越界 && 未访问过 && 未被翻过
                    if (inArea(newRow, newCol, rows, cols) && !visited[newRow][newCol] && board[newRow][newCol] == NOT_TO_DIG_BLACK) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            } else {
                // Character.forDigit(number, 10) 转为10进制的 char 类型标识
                board[row][col] = Character.forDigit(number, 10);
            }
        }
        return board;
    }

    private int getBombShellNumber(int clickRow, int clickCol, int rows, int cols, char[][] board) {
        int result = 0;
        for (int i = 0; i < DIRECTIONS.length; i++) {
            int newRow = clickRow + DIRECTIONS[i][0];
            int newCol = clickCol + DIRECTIONS[i][1];

            if (inArea(newRow, newCol, rows, cols) && board[newRow][newCol] == BOMBSHELL) {
                result++;
            }
        }
        return result;
    }

    private boolean inArea(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        int[] click = new int[]{3, 0};
        char[][] result = solution.updateBoard(board, click);
        for (char[] ca : result) {
            System.out.println(Arrays.toString(ca));
        }
    }
}

