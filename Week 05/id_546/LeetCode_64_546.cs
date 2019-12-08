using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 64. 最小路径和
    /// </summary>
    public class MinimumPathSum
    {
        public int MinPathSum(int[][] grid)
        {
            int m = grid.Length;
            int n = grid[0].Length;
            for (int i = 1; i < n; i++)
            {
                grid[0][i] += grid[0][i - 1];
            }
            for (int i = 1; i < m; i++)
            {
                grid[i][0] += grid[i - 1][0];
                for (int j = 1; j < n; j++)
                {
                    grid[i][j] += Math.Min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
            return grid[m - 1][n - 1];
        }


        public int MinPathSum2(int[][] grid)
        {
            int m = grid.Length, n = grid[0].Length;

            int[][] minSum = new int[m][];

            for(int i=0;i<m;i++)
            {
                minSum[i] = new int[n];
            }
            minSum[0][0] = grid[0][0];
            for (int i = 0; i < m; i++)
            {
                

                for (int j = 0; j < n; j++)
                {
                    if (i == 0 && j > 0) minSum[i][j] = minSum[i][j - 1] + grid[i][j];
                    else if (j == 0 && i > 0) minSum[i][j] = minSum[i - 1][j] + grid[i][j];
                    else if (i > 0 && j > 0) minSum[i][j] = Math.Min(minSum[i][j - 1], minSum[i - 1][j]) + grid[i][j];
                }
            }
            return minSum[m - 1][n - 1];
        }


        public int MinPathSum3(int[][] grid)
        {
            int m = grid.Length, n = grid[0].Length;

            int[,] minSum = new int[m,n];
            minSum[0,0] = grid[0][0];
            for (int i = 0; i < m; i++)
            {


                for (int j = 0; j < n; j++)
                {
                    if (i == 0 && j > 0) minSum[i,j] = minSum[i,j - 1] + grid[i][j];
                    else if (j == 0 && i > 0) minSum[i,j] = minSum[i - 1,j] + grid[i][j];
                    else if (i > 0 && j > 0) minSum[i,j] = Math.Min(minSum[i,j - 1], minSum[i - 1,j]) + grid[i][j];
                }
            }
            return minSum[m - 1,n - 1];
        }
    }
}
