namespace Poplar.Algorithm.WeekThree
{
    /// <summary>
    /// 搜索旋转排序数组
    /// https://leetcode.com/problems/search-in-rotated-sorted-array/
    /// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
    /// </summary>
    public class SearchInRotatedSortedArraySol
    {
        /// <summary>
        /// 二分查找。
        /// 当左半边是有序时并且target不在左半边范围内的，向右走。
        /// 当左半边是无序的并且target大于mid并且target小于索引0的位置，向右走。
        /// 否则就是向左走。
        /// </summary>
        /// <param name="nums"></param>
        /// <param name="target"></param>
        /// <returns></returns>
        public int Search(int[] nums, int target)
        {
            if (nums == null || nums.Length == 0)
            {
                return -1;
            }
            var lo = 0;
            var hi = nums.Length - 1;
            while (lo < hi)
            {
                var mid = (lo + hi) / 2;
                if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0]))
                {
                    lo = mid + 1;
                }
                else if (target > nums[mid] && target < nums[0])
                {
                    lo = mid + 1;
                }
                else
                {
                    hi = mid;
                }
            }
            return lo == hi && nums[lo] == target ? lo : -1;
        }
    }
}
