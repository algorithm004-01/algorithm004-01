using System;

namespace Poplar.Algorithm.WeekThree
{
    /// <summary>
    /// 分发饼干
    /// https://leetcode.com/problems/assign-cookies
    /// https://leetcode-cn.com/problems/assign-cookies
    /// </summary>
    public class AssignCookiesSol
    {
        public int FindContentChildren(int[] g, int[] s)
        {
            Array.Sort(g);
            Array.Sort(s);
            var count = 0;
            var i = 0;
            var j = 0;
            while (i < g.Length && j < s.Length)
            {
                if (g[i] <= s[j])
                {
                    i++;
                }
                j++;
            }
            return count;
        }
    }
}
