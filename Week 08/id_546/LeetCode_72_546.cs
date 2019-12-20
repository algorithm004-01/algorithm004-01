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
        //推荐解法
        public int MinDistance(string word1, string word2)
        {
            int m = word1.Length;
            int n = word2.Length;

            int[,] cost = new int[m + 1, n + 1];
            for (int i = 0; i <= m; i++)
                cost[i, 0] = i;
            for (int i = 1; i <= n; i++)
                cost[0, i] = i;

            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (word1[i] == word2[j])
                        cost[i + 1, j + 1] = cost[i, j];
                    else
                    {
                        int a = cost[i, j];
                        int b = cost[i, j + 1];
                        int c = cost[i + 1, j];
                        cost[i + 1, j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                        cost[i + 1, j + 1]++;
                    }
                }
            }
            return cost[m, n];
        }


        public int minDistance(String word1, String word2)
        {
            int n1 = word1.Length;
            int n2 = word2.Length;
            int[,] dp = new int[n1 + 1, n2 + 1];


            // 第一行
            for (int j = 1; j <= n2; j++) dp[0, j] = dp[0, j - 1] + 1;
            // 第一列
            for (int i = 1; i <= n1; i++) dp[i, 0] = dp[i - 1, 0] + 1;

            for (int i = 1; i <= n1; i++)
            {
                for (int j = 1; j <= n2; j++)
                {
                    if (word1[i - 1] == word2[j - 1]) dp[i, j] = dp[i - 1, j - 1];
                    else dp[i, j] = Math.Min(Math.Min(dp[i - 1, j - 1], dp[i, j - 1]), dp[i - 1, j]) + 1;
                }
            }
            return dp[n1, n2];
        }

    }
}
