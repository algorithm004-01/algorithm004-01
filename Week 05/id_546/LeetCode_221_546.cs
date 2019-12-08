using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 221. 最大正方形
    /// </summary>
    public class MaximalSquare
    {
        public int MaximalSquare1(char[][] matrix)
        {
            if (matrix.Length == 0) return 0;
            int m = matrix.Length, n = matrix[0].Length, result = 0;
            int[,] b = new int[m + 1,n + 1];
            for (int i = 1; i <= m; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    if (matrix[i - 1][j - 1] == '1')
                    {
                        b[i,j] = Math.Min(Math.Min(b[i,j - 1], b[i - 1,j - 1]), b[i - 1,j]) + 1;
                        result = Math.Max(b[i,j], result); 
                    }
                }
            }
            return result * result;
        }
    }
}
