using System;
using System.Collections.Generic;

namespace Poplar.Algorithm.WeekTwo
{
    /// <summary>
    /// 有效的字母异位词
    /// https://leetcode.com/problems/valid-anagram/
    /// https://leetcode-cn.com/problems/valid-anagram/
    /// </summary>
    public class ValidAnagramSol
    {
        public bool IsAnagram(string s, string t)
        {
            //return DicValid(s, t);
            //return Counter(s, t);
            return SortValid(s, t);
        }

        /// <summary>
        /// 计数器
        /// 一个循环，同时对计数器中的对应字母进行增加和减少，最后判断计数器中有没有不为零的。
        /// 时间复杂度是O(n)。
        /// </summary>
        /// <param name="s"></param>
        /// <param name="t"></param>
        /// <returns></returns>
        private bool Counter(string s, string t)
        {
            if (s.Length != t.Length)
            {
                return false;
            }
            var counter = new int[26];
            for (int i = 0; i < s.Length; i++)
            {
                counter[s[i] - 'a']++;
                counter[t[i] - 'a']--;
            }
            foreach (var item in counter)
            {
                if (item != 0)
                {
                    return false;
                }
            }
            return true;
        }

        /// <summary>
        /// 计数器的另外一种解法
        /// </summary>
        /// <param name="s"></param>
        /// <param name="t"></param>
        /// <returns></returns>
        private bool CounterTwo(string s, string t)
        {
            if (s.Length != t.Length)
            {
                return false;
            }
            var counter = new int[26];
            foreach (var c in s)
            {
                counter[c - 'a']++;
            }

            foreach (var c in t)
            {
                counter[c - 'a']--;
                if (counter[c - 'a'] < 0)
                {
                    return false;
                }
            }
            return true;
        }

        /// <summary>
        /// 字典，先将s的字符加入到字典中，再遍历t的字符，进行减少，如果发现有字符不在字典中，则证明是新的字母，直接返回false，
        /// 最后返回true
        /// </summary>
        /// <param name="s"></param>
        /// <param name="t"></param>
        /// <returns></returns>
        private bool DicValid(string s, string t)
        {
            if (s.Length != t.Length)
            {
                return false;
            }
            var map = new Dictionary<char, int>();
            foreach (var c in s)
            {
                if (map.ContainsKey(c))
                {
                    map[c]++;
                }
                else
                {
                    map.Add(c, 1);
                }
            }
            foreach (var c in t)
            {
                if (!map.ContainsKey(c))
                {
                    return false;
                }
                map[c]--;
                if (map[c] < 0)
                {
                    return false;
                }
            }
            return true;
        }

        /// <summary>
        /// 先排序再比较，因为有两个排序，时间复杂度是O(2logn)，也就是O(logn)
        /// </summary>
        /// <param name="s"></param>
        /// <param name="t"></param>
        /// <returns></returns>
        private bool SortValid(string s, string t)
        {
            if (s.Length != t.Length)
            {
                return false;
            }
            var arrS = s.ToCharArray();
            Array.Sort(arrS);
            s = new string(arrS);
            var arrT = t.ToCharArray();
            Array.Sort(arrT);
            t = new string(arrT);
            return s == t;
        }
    }
}
