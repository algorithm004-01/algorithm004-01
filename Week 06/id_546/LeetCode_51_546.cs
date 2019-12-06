using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hard
{
    /// <summary>
    /// 51. N皇后
    /// </summary>
    public class NQueens
    {
        
    }


    public class Solution
    {
        public List<List<String>> SolveNQueens(int n)
        {
            List<List<String>> res = new List<List<string>>();
            bool[] vertical = new bool[n];
            bool[] tiltU = new bool[2 * n - 1];
            bool[] tiltD = new bool[2 * n - 1];
            int[] h = new int[n];
            helper(res, h, vertical, tiltU, tiltD, n, 0);
            return res;
        }

        void helper(List<List<String>> res, int[] h, bool[] v, bool[] u, bool[] d, int n, int row)
        {
            if (row == n)
            {
                List<String> list = new List<string>();
                for (int i = 0; i < n; i++)
                {
                    char[] cs = new char[n];
                    Array.Fill(cs, '.');
                    cs[h[i]] = 'Q';
                    list.Add(new String(cs));
                }
                res.Add(list);
                return;
            }

            for (int col = 0; col < n; col++)
            {
                if (v[col] || u[col + row] || d[row - col + n - 1])
                {
                    continue;
                }
                v[col] = true;
                u[col + row] = true;
                d[row - col + n - 1] = true;
                h[row] = col;
                helper(res, h, v, u, d, n, row + 1);
                v[col] = false;
                u[col + row] = false;
                d[row - col + n - 1] = false;
            }
        }
    }



}
