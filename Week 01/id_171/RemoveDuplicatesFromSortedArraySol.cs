namespace Poplar.Algorithm.WeekOne
{
    /// <summary>
    /// 删除排序数组中的重复项
    /// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    /// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
    /// </summary>
    public class RemoveDuplicatesFromSortedArraySol
    {
        /// <summary>
        /// 双指针法，第一个指针j指向最后一个不重复的值，另外一个指针i遍历数组，
        /// 开始的时候，j指向0，i指向j + 1也就是1。
        /// i从1开始遍历数组，当i指向的值和j指向的值相等，就继续向前遍历，
        /// 当i指向的值和j指向的值不相等，让j先往前近一格（因为当前j指向的是最后一个不重复的值，此时要将另外一个不重复的值放进来，所以j要前进一格），
        /// 将i指向的值赋给j指向的位置。
        /// 整个数组遍历完成之后，j还是最后一个不重复的值的索引，因为返回的是数量，所以需要将j + 1再返回
        /// </summary>
        /// <param name="nums"></param>
        /// <returns></returns>
        public int RemoveDuplicates(int[] nums)
        {
            if (nums.Length < 2)
            {
                return nums.Length;
            }
            var j = 0;
            for (int i = 1; i < nums.Length; i++)
            {
                if (nums[i] != nums[j])
                {
                    nums[++j] = nums[i];
                }
            }
            return j + 1;
        }
    }
}
