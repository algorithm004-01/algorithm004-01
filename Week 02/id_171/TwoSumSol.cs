using System.Collections.Generic;

namespace Poplar.Algorithm.WeekTwo
{
    /// <summary>
    /// 两数之和
    /// https://leetcod.com/problems/two-sum/
    /// https://leetcode-cn.com/problems/two-sum/
    /// </summary>
    public class TwoSumSol
    {
        public int[] TwoSum(int[] nums, int target)
        {
            //return Force(nums, target);
            return Map(nums, target);
        }

        /// <summary>
        /// 使用字典，字典key为数组中的元素，value为该元素在字典中的索引。
        /// 在遍历数组的时候，去字典中看是否有一个key，它的值正好是target - nums[i]，
        /// 如果存在，则正好是num[i] + key = target，此时就找到了两个和是target的数，返回它们的索引。
        /// </summary>
        /// <param name="nums"></param>
        /// <param name="target"></param>
        /// <returns></returns>
        private int[] Map(int[] nums, in int target)
        {
            if (nums == null || nums.Length < 2)
            {
                return null;
            }
            var map = new Dictionary<int, int>();
            for (int i = 0; i < nums.Length; i++)
            {
                if (map.ContainsKey(target - nums[i]))
                {
                    return new int[] { i, map[target - nums[i]] };
                }
                if (!map.ContainsKey(nums[i]))
                {
                    map.Add(nums[i], i);
                }
            }
            return null;
        }

        /// <summary>
        /// 暴力解法。
        /// 双重循环，判断nums[i] + nums[j]是否等于target。
        /// 时间复杂度是O(n²)
        /// </summary>
        /// <param name="nums"></param>
        /// <param name="target"></param>
        /// <returns></returns>
        private int[] Force(int[] nums, int target)
        {
            if (nums == null || nums.Length < 2)
            {
                return null;
            }
            for (int i = 0; i < nums.Length - 1; i++)
            {
                for (int j = i + 1; j < nums.Length; j++)
                {
                    if (nums[i] + nums[j] == target)
                    {
                        return new int[] { i, j };
                    }
                }
            }
            return null;
        }
    }
}
