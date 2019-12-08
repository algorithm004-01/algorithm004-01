using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 200. 岛屿数量
    /// </summary>
    public class NumberOfIslands
    {
        private int n;
        private int m;

        public int NumIslands(char[][] grid)
        {
            int count = 0;
            n = grid.Length;
            if (n == 0) return 0;
            m = grid[0].Length;
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                    if (grid[i][j] == '1')
                    {
                        DFSMarking(grid, i, j);
                        ++count;
                    }
            }
            return count;
        }

        private void DFSMarking(char[][] grid, int i, int j)
        {
            if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
            grid[i][j] = '0';
            DFSMarking(grid, i + 1, j);
            DFSMarking(grid, i - 1, j);
            DFSMarking(grid, i, j + 1);
            DFSMarking(grid, i, j - 1);
        }
    }
}
