using System;
using System.Collections.Generic;
using System.Linq;

namespace Medium
{
    /// <summary>
    /// 49. 字母异位词分组
    /// </summary>
    public class GroupAnagrams
    {
        /// <summary>
        /// 暴力法，使用键值对先分组再返回结果
        /// </summary>
        /// <param name="strs"></param>
        /// <returns></returns>
        public static IList<IList<string>> GroupAnagrams1(string[] strs)
        {
            var dic = new Dictionary<string, IList<string>>();

            foreach (string s in strs)
            {
                var arr = s.ToCharArray();
                Array.Sort(arr);
                string key = new string(arr);

                if (!dic.ContainsKey(key))
                {
                    dic[key] = new List<string>();
                }
                dic[key].Add(s);
            }

            return dic.Values.ToList();
        }

        public static void Run()
        {
            string[] arr = { "eat", "tea", "tan", "ate", "nat", "bat" };

            var result = GroupAnagrams1(arr);

            foreach (IList<string> l in result)
            {
                foreach (var a in l)
                {
                    Console.Write(a + "\t");
                }
                Console.Write("\n");
            }
        }
    }
}