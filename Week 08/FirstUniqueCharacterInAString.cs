using System;
using System.Collections.Generic;
using System.Text;

namespace Poplar.Algorithm.WeekSix
{
    /// <summary>
    /// https://leetcode-cn.com/problems/first-unique-character-in-a-string
    /// </summary>
    public class FirstUniqueCharacterInAString
    {
        public int FirstUniqChar(string s)
        {
            Dictionary<char, int> count = new Dictionary<char, int>();
            for (var i = 0; i < s.Length; i++)
            {
                char c = s[i];
                if (count.ContainsKey(c))
                {
                    count[c]++;
                }
                else
                {
                    count.Add(c, 1);
                }
            }
            for (var i = 0; i < s.Length; i++)
            {
                if (count[s[i]] == 1)
                    return i;
            }
            return -1;
        }
    }
}
