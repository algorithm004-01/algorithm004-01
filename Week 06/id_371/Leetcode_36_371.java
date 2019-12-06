import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-20 05:46
 **/

public class Leetcode_36_371 {

    /**
     *
     * @author Shaobo.Qian
     * @date 2019/11/20
     */
    public boolean isValidSudoku1(char[][] board) {
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] cols = new HashSet[9];
        HashSet<Integer>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Integer>();
            cols[i] = new HashSet<Integer>();
            boxes[i] = new HashSet<Integer>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = (int) board[i][j];
                if (board[i][j] != '.') {
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (rows[i].contains(num) || cols[j].contains(num)  || boxes[boxIndex].contains(num)) return false;
                    rows[i].add(num);
                    cols[j].add(num);
                    boxes[boxIndex].add(num);
                }
            }
        }
        return true;
    }
    /**
     * 仿解1:迭代(关键:对子数独的映射)
     *
     * @author Shaobo.Qian
     * @date 2019/11/20
     * @link https://leetcode-cn.com/problems/valid-sudoku/solution/you-xiao-de-shu-du-by-leetcode/
     */
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = (int) board[i][j];
                if (board[i][j] != '.') {
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (rows[i].containsKey(num) || cols[j].containsKey(num)  || boxes[boxIndex].containsKey(num)) return false;
                    rows[i].put(num, 1);
                    cols[j].put(num, 1);
                    boxes[boxIndex].put(num, 1);
                }
            }
        }
        return true;
    }
}
