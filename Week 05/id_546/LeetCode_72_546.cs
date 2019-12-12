using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hard
{
    /// <summary>
    /// 72. 编辑距离
    /// </summary>
    public class EditDistance
    {
        public int MinDistance(string word1, string word2)
        {
            int m = word1.Length;
            int n = word2.Length;

            int[,] cost = new int[m + 1,n + 1];
            for (int i = 0; i <= m; i++)
                cost[i,0] = i;
            for (int i = 1; i <= n; i++)
                cost[0,i] = i;

            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (word1[i] == word2[j])
                        cost[i + 1,j + 1] = cost[i,j];
                    else
                    {
                        int a = cost[i,j];
                        int b = cost[i,j + 1];
                        int c = cost[i + 1,j];
                        cost[i + 1,j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                        cost[i + 1,j + 1]++;
                    }
                }
            }
            return cost[m,n];
        }
    }
}
