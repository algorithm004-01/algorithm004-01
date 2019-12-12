using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 338. 比特位计数
    /// </summary>
    public class CountingBits
    {
        public int[] CountBits(int num)
        {

            int[] bits = new int[num + 1];

            for (int i = 1; i <= num; i++)
            {
         
                bits[i] += bits[(i & (i - 1))] +1;
            }
            return bits;
        }
    }
}
