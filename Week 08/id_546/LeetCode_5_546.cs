using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    public class LongestPalindromicSubstring
    {
        public string LongestPalindrome(string s)
        {
            int n = s.Length;
            string res = "";
            bool[,] dp = new bool[n,n];
            for (int i = n - 1; i >= 0; i--)
            {
                for (int j = i; j < n; j++)
                {
                    dp[i,j] = s[i] == s[j] && (j - i < 2 || dp[i + 1,j - 1]); //j - i 代表长度减去 1        
                    if (dp[i,j] && j - i + 1 > res.Length)
                    {
                        res = s.Substring(i, j + 1-i);
                    }
                }
            }
            return res;


            



        }
    }
}
