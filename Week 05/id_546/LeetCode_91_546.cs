using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 91. 解码方法
    /// </summary>
    public class DecodeWays
    {
        public int NumDecodings(string s)
        {
            if (s == null || s.Length == 0)
            {
                return 0;
            }
            int n = s.Length;
            int[] dp = new int[n];
            dp[0] = s[0] != '0' ? 1 : 0;

            for (int i = 1; i < n; i++)
            {
                int first = int.Parse( s.Substring(i, 1));
                int second = int.Parse(s.Substring(i - 1,2));
                if (first >= 1 && first <= 9)
                {
                    dp[i] += dp[i - 1];
                }
                if (second >= 10 && second <= 26)
                {
                    dp[i] += i >= 2 ? dp[i - 2] : 1;
                }
            }
            return dp[n - 1];
        }


        public int numDecodings2(String s)
        {
            int n = s.Length;
            if (n == 0) return 0;

            int[] memo = new int[n + 1];
            memo[n] = 1;
            memo[n - 1] = s[n - 1] != '0' ? 1 : 0;

            for (int i = n - 2; i >= 0; i--)
                if (s[i] == '0') continue;
                else memo[i] = (int.Parse(s.Substring(i, 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

            return memo[0];
        }
    }
}
