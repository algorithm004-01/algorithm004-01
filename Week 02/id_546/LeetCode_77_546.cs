using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 77. 组合
    /// </summary>
    public class Combinations
    {
        public IList<IList<int>> Combine(int n, int k)
        {
            IList<IList<int>> combs = new List<IList<int>>();
            combine(combs, new List<int>(), 1, n, k);
            return combs;
        }



        public static void combine(IList<IList<int>> combs, List<int> comb, int start, int n, int k)
        {
            if (k == 0)
            {
                combs.Add(new List<int>(comb));
                return;
            }
            for (int i = start; i <= n; i++)
            {
                comb.Add(i);
                combine(combs, comb, i + 1, n, k - 1);
                comb.RemoveAt(comb.Count - 1);
            }
        }

    }
}
