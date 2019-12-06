using System;

namespace Poplar.Algorithm.WeekFive
{
    /// <summary>
    /// 最小路径和
    /// https://leetcode.com/problems/minimum-path-sum/
    /// https://leetcode-cn.com/problems/minimum-path-sum/
    /// </summary>
    public class MinimumPathSumSol
    {
        /// <summary>
        /// 动态规划。
        /// 定义状态f(i,j)是到出口的最小路径。
        /// dp方程：dp(i, j) = a[i][j] + min(dp(i + 1, j), dp(i, j + 1))
        /// </summary>
        /// <param name="grid"></param>
        /// <returns></returns>
        public int MinPathSum(int[][] grid)
        {
            var container = new int[grid[0].Length];
            for (int i = container.Length - 1; i >= 0; i--)
            {
                container[i] = (i == container.Length - 1)
                    ? grid[grid.Length - 1][i]
                    : grid[grid.Length - 1][i] + container[i + 1];
            }
            for (int i = grid.Length - 2; i >= 0; i--)
            {
                var curLine = grid[i];
                for (int j = curLine.Length - 1; j >= 0; j--)
                {
                    if (j == curLine.Length - 1)
                    {
                        container[j] = curLine[j] + container[j];
                    }
                    else
                    {
                        container[j] = curLine[j] + Math.Min(container[j + 1], container[j]);
                    }
                }
            }
            return container[0];
        }
    }
}
