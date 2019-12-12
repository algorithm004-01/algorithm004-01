using System;
using System.Collections.Generic;
using System.Text;

namespace Poplar.Algorithm.WeekSix
{
    public class FriendCirclesSol
    {
        public int FindCircleNum(int[][] m)
        {
            var visited = new int[m.Length];
            var count = 0;
            for (int i = 0; i < m.Length; i++)
            {
                if (visited[i] == 0)
                {
                    Dfs(m, visited, i);
                    count++;
                }
            }
            return count;
        }

        private void Dfs(int[][] m, int[] visited, int i)
        {
            for (int j = 0; j < visited.Length; j++)
            {
                if (m[i][j] == 1 && visited[j] == 0)
                {
                    visited[j] = 1;
                    Dfs(m, visited, j);
                }
            }
        }
    }
}
