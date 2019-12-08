//编写一个程序，通过已填充的空格来解决数独问题。
//
// 一个数独的解法需遵循如下规则：
//
//
// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
//
// 空白格用 '.' 表示。
//
//
//
// 一个数独。
//
//
//
// 答案被标成红色。
//
// Note:
//
//
// 给定的数独序列只包含数字 1-9 和字符 '.' 。
// 你可以假设给定的数独只有唯一解。
// 给定数独永远是 9x9 形式的。
//
// Related Topics 哈希表 回溯算法
package com.aseara.leetcode.editor.cn.a37;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * desc: 37.解数独 <br />
 * Date: 2019/11/21 <br/>
 *
 * @author qiujingde
 */
class SudokuSolver {
    private Solution solution = new Solution();

    @Test
    void test1() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solution.solveSudoku(board);
        char[][] expected = {
                {'5','3','4','6','7','8','9','1','2'},
                {'6','7','2','1','9','5','3','4','8'},
                {'1','9','8','3','4','2','5','6','7'},
                {'8','5','9','7','6','1','4','2','3'},
                {'4','2','6','8','5','3','7','9','1'},
                {'7','1','3','9','2','4','8','5','6'},
                {'9','6','1','5','3','7','2','8','4'},
                {'2','8','7','4','1','9','6','3','5'},
                {'3','4','5','2','8','6','1','7','9'}
        };
        assertArrayEquals(expected, board);
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        int[] check = new int[27];
        initCheck(board, check);
        dfs(board, 0, 0, check);
    }

    private void initCheck(char[][] board, int[] check) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = 1 << (board[i][j] - '1');

                    int col = 9 + j;
                    int box = 18 + (i / 3) * 3 + j / 3;

                    check[i] |= num;
                    check[col] |= num;
                    check[box] |= num;
                }
            }
        }
    }

    private boolean dfs(char[][] board, int i, int j, int[] check) {
        if (i == 9) {
            return true;
        }

        int col = 9 + j;
        int box = 18 + (i / 3) * 3 + j / 3;
        int curCheck = check[i] | check[col] | check[box];

        int nextI = j == 8 ? i + 1 : i;
        int nextJ = j == 8 ? 0 : j + 1;

        if (board[i][j] != '.') {
            return dfs(board, nextI, nextJ, check);
        }
        for (int k = 0; k < 9; k++) {
            int num = 1 << k;
            if ((curCheck & num) == 0) {
                check[i] |= num;
                check[col] |= num;
                check[box] |= num;

                if (dfs(board, nextI, nextJ, check)) {
                    board[i][j] = (char) (k + '1');
                    return true;
                }

                check[i] ^= num;
                check[col] ^= num;
                check[box] ^= num;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
