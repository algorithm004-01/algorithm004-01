import java.util.*;
/**
 * 扫雷游戏
 */
public class Solution {
    /**
     * 扫雷游戏
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        return updateBoardHelper(board, click[0], click[1]);
    }

    private char[][] updateBoardHelper(char[][] board, int x, int y) {
        //如果一开始点击是雷，则退出游戏
        int nums = getNums(board, x, y);
        if (nums == 0)
            board[x][y] = 'B';
        else {
            //forDigit函数，将第一个参数转为字符。radix 有效值为 2~36.nums 小于 10 则为数字字符，否则为'a' + nums - 10，也就是 26 个小写英文字母
            board[x][y] = Character.forDigit(nums, 10);
            //退出时因为，题目要求无需遍历所有点，遇到雷即可。
            return board;
        }
        //只遍历周围八个点中为 E 的点。
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i < 0 || x + i > board.length - 1 || y + j < 0 || y + j > board[0].length - 1 || board[x + i][y + j] != 'E')
                    continue;
                board = updateBoardHelper(board, x + i, y + j);
            }
        }
        return board;
    }

    /*
    计算当前点周围八个点雷的数量
     */
    private int getNums(char[][] board, int x, int y) {
        int num = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i < 0 || x + i > board.length - 1 || y + j < 0 || y + j > board[0].length - 1 || board[x + i][y + j] != 'M')
                    continue;
                num++;
            }
        }
        return num;
    }
}