using System;

namespace Poplar.Algorithm.WeekOne
{
    /// <summary>
    /// 旋转数组
    /// https://leetcode.com/problems/rotate-array/
    /// https://leetcode-cn.com/problems/rotate-array/
    /// </summary>
    public class RotateArraySol
    {
        public void Rotate(int[] nums, int k)
        {
            //RotateOne(nums, k);
            RotateTwo(nums, k);
        }

        /// <summary>
        /// 循环交换
        /// </summary>
        /// <param name="nums"></param>
        /// <param name="k"></param>
        private void RotateTwo(int[] nums, int k)
        {
            var length = nums.Length;
            k = k % length;
            if (k == length)
            {
                return;
            }
            var count = 0;
            for (var start = 0; count < nums.Length; start++)
            {
                var curIndex = start;
                var cur = nums[curIndex];
                do
                {
                    var temp = cur;
                    var nextIndex = (curIndex + k) % length;
                    cur = nums[nextIndex];
                    nums[nextIndex] = temp;
                    curIndex = nextIndex;
                    count++;
                } while (start != curIndex);
            }
        }

        /// <summary>
        /// 第一种方法，使用额外的数组
        /// </summary>
        /// <param name="nums"></param>
        /// <param name="k"></param>
        public void RotateOne(int[] nums, int k)
        {
            var length = nums.Length;
            k = k % length;
            if (k == length)
            {
                return;
            }
            var arr = new int[length];
            Array.Copy(nums, 0, arr, 0, length);
            Array.Copy(arr, 0, nums, 0 + k, length - k);
            Array.Copy(arr, nums.Length - k, nums, 0, k);
        }
    }
}
