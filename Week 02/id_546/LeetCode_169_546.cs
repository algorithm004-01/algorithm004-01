using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Easy
{
    /// <summary>
    /// 169. 求众数
    /// </summary>
    public class MajorityElement
    {
        /// <summary>
        /// 方法一：暴力法，键值对
        /// </summary>
        /// <param name="nums"></param>
        /// <returns></returns>
        public int MajorityElement1(int[] nums)
        {
            int f=nums.Length / 2;
            Dictionary<int, int> dic = new Dictionary<int, int>();

            foreach (int n in nums)
            {
                if (!dic.ContainsKey(n))
                {
                    dic.Add(n, 0);
                }
                dic[n] = dic[n] + 1;
            }

            return dic.OrderByDescending(a => a.Value).First().Key;
          
            
             
        }
    }
}
