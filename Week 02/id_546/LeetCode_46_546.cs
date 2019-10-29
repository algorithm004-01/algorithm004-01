using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 46. 全排列
    /// </summary>
    public class Permutations
    {
        public IList<IList<int>> Permute(int[] nums)
        {
            IList<IList<int>> list = new List<IList<int>>();
           
            backtrack(list, new List<int>(), nums);

            return list;
        }

 

        private void backtrack(IList<IList<int>> list, List<int> tempList, int[] nums)
        {
            if (tempList.Count == nums.Length)
            {
                list.Add(new List<int>(tempList));
            }
            else
            {
                for (int i = 0; i < nums.Length; i++)
                {
                    if (tempList.Contains(nums[i])) continue; 
                    tempList.Add(nums[i]);
                    backtrack(list, tempList, nums);
                    tempList.RemoveAt(tempList.Count - 1);
                }
            }
        }

    }
}
