using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 33. 搜索旋转排序数组
    /// </summary>
    public class SearchInRotatedSortedArray
    {
        // 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 0->4

        public int Search(int[] nums, int target)
        {
            int left = 0;
            int right = nums.Length-1;

            while (left <= right)
            {

                int mid = (left + right) / 2;

                int _num = 0;

                //如果第一个元素同时大于中间元素和target，或者第一个元素同时小于中间元素和target，就获取中间值
                if (nums[mid] < nums[0] == (target < nums[0]))
                {
                    _num = nums[mid];
                }
                else
                {
                    //如果第一个元素大于指定的元素，指定其位最小值，否则指定为最大值，以便进行二分查找
                    _num = target < nums[0] ? int.MinValue : int.MaxValue;
                }
                //进行二分查找
                if (_num < target)
                    left = mid + 1;
                else if (_num > target)
                    right = mid-1;
                else
                    return mid;
            }
            return -1;

        }
    }
}
