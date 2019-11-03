using System;
using System.Linq;

namespace Easy
{
    /// <summary>
    /// 242. 有效的字母异位词
    /// </summary>
    public class ValidAnagram
    {
        //字母异位词：
        //一边单词字母出现的频率等于另一边单词出现的频率但字母位置可以不一样
        //两边单词个数不同肯定为 false

        /// <summary>
        /// 解法一：暴力解法
        /// </summary>
        /// <param name="s"></param>
        /// <param name="t"></param>
        /// <returns></returns>
        public static bool IsAnagram(String s, String t)
        {
            if (s.Length != t.Length)
            {
                return false;
            }

            var arrA = s.ToCharArray();
            var arrB = t.ToCharArray();

            Array.Sort(arrA);
            Array.Sort(arrB);

            //使用SequenceEqual比较值
            return arrA.SequenceEqual(arrB);

            //错误的比较数组值,Equals来自于Object的比较，而不是单纯的值比较
            //var error = arrA.Equals(arrB);
        }

        /// <summary>
        /// 解法二：使用字符小标，hash存储
        /// </summary>
        /// <param name="s"></param>
        /// <param name="t"></param>
        /// <returns></returns>
        public static bool IsAnagram2(String s, String t)
        {
            if (s.Length != t.Length)
            {
                return false;
            }

            int[] alphabet = new int[26];
            for (int i = 0; i < s.Length; i++)
            {
                alphabet[s[i] - 'a']++;
                alphabet[t[i] - 'a']--;
            }
            return !alphabet.Any(i => i != 0);
        }

        public static void Run()
        {
            

            bool b = IsAnagram("anagram", "nagaram");
            Console.WriteLine(b);
        }
    }
}