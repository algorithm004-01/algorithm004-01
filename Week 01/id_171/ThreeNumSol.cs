using System;
using System.Collections.Generic;
using System.Linq;

namespace Poplar.Algorithm.WeekOne
{
    /// <summary>
    /// 三数之和
    /// https://leetcode.com/problems/3sum/
    /// https://leetcode-cn.com/problems/3sum/
    /// </summary>
    public class ThreeNumSol
    {
        public IList<IList<int>> ThreeSum(int[] nums)
        {
            //return this.ThreeSumOne(nums);
            return this.ThreeSumTwo(nums);
        }

        /// <summary>
        /// 双指针
        /// </summary>
        /// <param name="nums"></param>
        /// <returns></returns>
        public IList<IList<int>> ThreeSumTwo(int[] nums)
        {
            Array.Sort(nums);
            var result = new List<IList<int>>();
            for (int k = 0; k < nums.Length; k++)
            {
                if (k == 0 || nums[k] != nums[k - 1])
                {
                    var cur = nums[k];
                    var i = k + 1;
                    var j = nums.Length - 1;
                    while (i < j)
                    {
                        var sum = nums[i] + nums[j] + cur;
                        if (sum == 0)
                        {
                            result.Add(new List<int>() { nums[i++], nums[j--], nums[k] });
                            while (i < j && nums[i] == nums[i - 1])
                            {
                                i++;
                            }
                            while (i < j && nums[j] == nums[j + 1])
                            {
                                j--;
                            }
                        }
                        else if (sum < 0)
                        {
                            i++;
                        }
                        else
                        {
                            j--;
                        }
                    }
                }
            }
            return result;
        }

        /// <summary>
        /// 暴力破解，三层循环嵌套，时间复杂度是O(n³)，空间复杂度是O(1)，没有消耗额外空间
        /// </summary>
        /// <param name="nums"></param>
        /// <returns></returns>
        public IList<IList<int>> ThreeSumOne(int[] nums)
        {
            var temp = nums.ToList();
            temp.Sort();
            nums = temp.ToArray();
            var result = new List<IList<int>>();
            for (int i = 0; i < nums.Length - 2; i++)
            {
                for (int j = i + 1; j < nums.Length - 1; j++)
                {
                    if (j > i + 1 && nums[j] == nums[j] - 1)
                    {
                        continue;
                    }
                    for (int k = j + 1; k < nums.Length; k++)
                    {
                        if (nums[i] + nums[j] + nums[k] == 0)
                        {
                            result.Add(new List<int>() { nums[i], nums[j], nums[k] });
                            break;
                        }
                    }
                }
            }
            return result;
        }
    }
}
