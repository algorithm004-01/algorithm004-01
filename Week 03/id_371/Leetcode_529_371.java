/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-31 17:29
 **/

public class Leetcode_529_371 {

    /**
     * 仿解1:DFS
     *
     * @param board 字典
     * @param click 传入的坐标
     * @return
     * @link https://leetcode.com/problems/minesweeper/discuss/99826/Java-Solution-DFS-%2B-BFS
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int nRow = board.length;
        int nColumn = board[0].length;
        //1.坐标
        int row = click[0];
        int col = click[1];

        //1.递归出口
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        } else {
            //2.处理当前节点(找出当前坐标邻点中有多少雷)
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;//当前节点
                    int r = row + i;
                    int c = col + j;
                    if (r < 0 || r >= nRow || c < 0 || c >= nColumn) continue;//超出边界,不处理
                    if (board[r][c] == 'M' || board[r][c] == 'X') count++;
                }
            }
            if (count > 0) {
                board[row][col] = (char) (count + '0');
            } else {
                //3.带上参数,去下一层 递归调用
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int r = row + i;
                        int c = col + j;
                        if (r < 0 || r >= nRow || c < 0 || c >= nColumn) continue;//超出边界,不处理

                    }
                }
            }

        }
        return board;
    }

}
