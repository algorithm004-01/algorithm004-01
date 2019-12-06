public class LeetCode_33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new LeetCode_33_SearchInRotatedSortedArray().new Solution();
        int res;
        res = solution.search(new int[]{1}, 1);
        assert res == 0;
        res = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        assert res == 4;
        res = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        assert res == -1;
    }


    class Solution4 {
        public int search(int[] nums, int target) {

            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int middle = low + (high - low + 1) / 2;
                if ((nums[0] <= target && target < nums[middle]) || (nums[0] > nums[middle] && nums[middle] > target) || (nums[middle] < nums[0] && nums[0] <= target)) {
                    high = middle - 1;
                } else {
                    low = middle;
                }
            }

            return low == high && nums[low] == target ? low : -1;
        }
    }

    class Solution {
        public int search(int[] nums, int target) {

            if (nums.length == 0) return -1;

            // 找到旋转点
            int minIndex = findMinIndex(nums);
            if (nums[minIndex] == target) return minIndex;
            int low = 0;
            int high = nums.length - 1;
            if (target > nums[high]) {
                high = minIndex - 1;
            } else {
                low = minIndex;
            }
            // 二分查找
            while (low < high) {
                int middle = low + (high - low) / 2;
                if (target > nums[middle]) {
                    low = middle + 1;
                } else {
                    high = middle;
                }
            }

            return low == high && nums[low] == target ? low : -1;
        }

        private int findMinIndex(int[] nums) {

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
            return low;
        }
    }

    class Solutio2 {
        public int search(int[] nums, int target) {

            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int middle = low + (high - low) / 2;
                if ((nums[0] > target) ^ (nums[0] > nums[middle]) ^ (target > nums[middle])) {
                    low = middle + 1;
                } else {
                    high = middle;
                }
            }

            return low == high && nums[low] == target ? low : -1;
        }
    }

    class Solution1 {
        public int search(int[] nums, int target) {

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }

            return -1;
        }
    }

}