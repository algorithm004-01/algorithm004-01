using System;

namespace Poplar.Algorithm.WeekOne
{
    /// <summary>
    /// 合并两个有序数组
    /// https://leetcode.com/problems/merge-sorted-array/
    /// https://leetcode-cn.com/problems/merge-sorted-array/
    /// </summary>
    public class MergeSortedArraySol
    {
        public void Merge(int[] nums1, int m, int[] nums2, int n)
        {
            //this.MergeOne(nums1, m, nums2, n);
            //this.MergeTwo(nums1, m, nums2, n);
            this.MergeThree(nums1, m, nums2, n);
        }

        private void MergeThree(int[] nums1, in int m, int[] nums2, int n)
        {
            int i = m - 1, j = n - 1, k = m + n - 1;
            while (i > -1 && j > -1)
            {
                if (nums1[i] >= nums2[j])
                {
                    nums1[k--] = nums1[i--];
                }
                else
                {
                    nums1[k--] = nums2[j--];
                }
            }
            if (j > -1)
            {
                Array.Copy(nums2, 0, nums1, 0, j + 1);
            }
        }

        private void MergeTwo(int[] nums1, in int m, int[] nums2, int n)
        {
            var arr = new int[nums1.Length];
            Array.Copy(nums1, 0, arr, 0, m);
            var k = 0;
            int i = 0, j = 0;
            while (i < m && j < n)
            {
                nums1[k++] = arr[i] <= nums2[j] ? arr[i++] : nums2[j++];
            }
            if (i < m)
            {
                Array.Copy(arr, i, nums1, k, m - i);
            }
            else
            {
                Array.Copy(nums2, j, nums1, k, n - j);
            }

        }

        private void MergeOne(int[] nums1, in int m, int[] nums2, int n)
        {
            Array.Copy(nums2, 0, nums1, m, n);
            Array.Sort(nums1, 0, m + n);
        }
    }
}
