public class LeetCode_153_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new LeetCode_153_FindMinimumInRotatedSortedArray().new Solution();
    }


    class Solution {
        public int findMin(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                // 左中位数
                int middle = low + (high - low) / 2;
                if (nums[middle] > nums[high]) {
                    low = middle + 1;
                } else {
                    high = middle;
                }
            }
            return low == high ? nums[low] : null;
        }
    }

}