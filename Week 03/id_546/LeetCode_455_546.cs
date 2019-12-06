using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Easy
{
    /// <summary>
    /// 455. 分发饼干
    /// </summary>
    public class AssignCookies
    {
        public int FindContentChildren(int[] g, int[] s)
        {
            Array.Sort(g);
            Array.Sort(s);
            int i = 0;
            for (int j = 0; i < g.Length && j < s.Length; j++)
            {
                if (g[i] <= s[j])
                {
                    i++;
                }
            }
            return i;
        }
    }
}
