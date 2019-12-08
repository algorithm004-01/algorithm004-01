using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 47. 全排列 II
    /// </summary>
    public class PermutationsII
    {
     

        public IList<IList<int>> PermuteUnique(int[] nums)
        {
            IList<IList<int>> list = new List<IList<int>>();
            Array.Sort(nums);
            backtrack(list, new List<int>(), nums, new bool[nums.Length]);
            return list;
        }

        private void backtrack(IList<IList<int>> list, List<int> tempList, int[] nums, bool[] used)
        {
            if (tempList.Count == nums.Length)
            {
                list.Add(new List<int>(tempList));
            }
            else
            {
                for (int i = 0; i < nums.Length; i++)
                {
                    if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                    used[i] = true;
                    tempList.Add(nums[i]);
                    backtrack(list, tempList, nums, used);
                    used[i] = false;
                    tempList.RemoveAt(tempList.Count- 1);
                }
            }
        }


    }
}
