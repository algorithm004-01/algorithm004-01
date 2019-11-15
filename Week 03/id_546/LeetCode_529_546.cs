using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 529. 扫雷游戏
    /// </summary>
    public class Minesweeper
    {
       

        /// <summary>
        /// DFS
        /// </summary>
        /// <param name="board"></param>
        /// <param name="click"></param>
        /// <returns></returns>
        public char[][] UpdateBoard(char[][] board, int[] click)
        {
            int m = board.Length, n = board[0].Length;
            int row = click[0], col = click[1];

            if (board[row][col] == 'M')
            { // Mine
                board[row][col] = 'X';
            }
            else
            { // Empty
              // Get number of mines first.
                int count = 0;
                for (int i = -1; i < 2; i++)
                {
                    for (int j = -1; j < 2; j++)
                    {
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                        if (board[r][c] == 'M' || board[r][c] == 'X') count++;
                    }
                }

                if (count > 0)
                { // If it is not a 'B', stop further DFS.
                    board[row][col] = (char)(count + '0');
                }
                else
                { // Continue DFS to adjacent cells.
                    board[row][col] = 'B';
                    for (int i = -1; i < 2; i++)
                    {
                        for (int j = -1; j < 2; j++)
                        {
                            if (i == 0 && j == 0) continue;
                            int r = row + i, c = col + j;
                            if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                            if (board[r][c] == 'E') UpdateBoard(board, new int[] { r, c });
                        }
                    }
                }
            }

            return board;
        }

        /// <summary>
        /// BFS
        /// </summary>
        /// <param name="board"></param>
        /// <param name="click"></param>
        /// <returns></returns>
        public char[][] UpdateBoard2(char[][] board, int[] click)
        {
            int m = board.Length, n = board[0].Length;
            Queue<int[]> queue = new Queue<int[]>();
            queue.Enqueue(click);

            while (queue.Any())
            {
                int[] cell = queue.Dequeue();
                int row = cell[0], col = cell[1];

                if (board[row][col] == 'M')
                { // Mine
                    board[row][col] = 'X';
                }
                else
                { // Empty
                  // Get number of mines first.
                    int count = 0;
                    for (int i = -1; i < 2; i++)
                    {
                        for (int j = -1; j < 2; j++)
                        {
                            if (i == 0 && j == 0) continue;
                            int r = row + i, c = col + j;
                            if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                            if (board[r][c] == 'M' || board[r][c] == 'X') count++;
                        }
                    }

                    if (count > 0)
                    { // If it is not a 'B', stop further BFS.
                        board[row][col] = (char)(count + '0');
                    }
                    else
                    { // Continue BFS to adjacent cells.
                        board[row][col] = 'B';
                        for (int i = -1; i < 2; i++)
                        {
                            for (int j = -1; j < 2; j++)
                            {
                                if (i == 0 && j == 0) continue;
                                int r = row + i, c = col + j;
                                if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                                if (board[r][c] == 'E')
                                {
                                    queue.Enqueue(new int[] { r, c });
                                    board[r][c] = 'B';  
                                }
                            }
                        }
                    }
                }
            }

            return board;
        }
    }
}
