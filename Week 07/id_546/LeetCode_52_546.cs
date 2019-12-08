using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hard
{
    /// <summary>
    /// 52. N皇后 II
    /// </summary>
    public class NQueensII
    {
        private int size;
        private int count;
        private void Solve(int row, int ld, int rd)
        {
            if (row == size)
            {
                count++;
                return;
            }
            int pos = size & (~(row | ld | rd));
            while (pos != 0)
            {
                int p = pos & (-pos);
                pos -= p; // pos &= pos - 1;
                Solve(row | p, (ld | p) << 1, (rd | p) >> 1);
            }
        }
        public int TotalNQueens(int n)
        {
            count = 0;
            size = (1 << n) - 1;
            Solve(0, 0, 0);
            return count;
        }

    }

}
