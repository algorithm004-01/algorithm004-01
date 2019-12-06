namespace Poplar.Algorithm.WeekThree
{
    /// <summary>
    /// 寻找旋转排序数组中的最小值
    /// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    /// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
    /// </summary>
    public class FindMinimumInRotatedSortedArraySol
    {
        /// <summary>
        /// 二分查找法
        /// </summary>
        /// <param name="nums"></param>
        /// <returns></returns>
        public int FindMin(int[] nums)
        {
            if (nums.Length == 1)
            {
                return nums[0];
            }
            var lo = 0;
            var hi = nums.Length - 1;
            while (lo < hi)
            {
                if (nums[lo] < nums[hi])
                {
                    return nums[lo];
                }
                var mid = (lo + hi) / 2;
                //新的右边界必须是mid + 1，左边界必须是mid。
                //当前循环时，如果左半部分的左边值大于右边值，则证明旋转点在左半部分，此时左半部分的右边界是一个较小的值，它可能是最小值，所以新的右边界不能加1。
                //如果左半部分的左边值小于右边值，则旋转点在右半部分，但是并不会是右半部分的左边界值，因为这个值大于是大于左半部分的左边界值的，所以新的左边界需要加1
                if (nums[lo] > nums[mid])
                {
                    hi = mid;
                }
                else
                {
                    lo = mid + 1;
                }
            }
            return nums[lo];
        }
    }
}
