package Greedy;

public class LeetCode_33_276 {
    //思路：
    //1.还原排序数组，再用二分法查找
    //2.直接用二分法查找
    //找到最小值位置
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid = (lo + hi + 1) >>> 1;
            if (target > nums[mid] && target > nums[lo])
        }
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;
        int lo = 0,hi = nums.length-1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        int min = lo;
        lo = (target <= nums[nums.length-1])? min : 0;
        hi = (target > nums[nums.length-1] ) ? min-1 : nums.length-1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target) hi = mid - 1;
            else if (nums[mid] == target) return mid;
            else lo = mid + 1;
        }
        return -1;
    }

    //直接二分
    public int search (int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid = (hi +hi)/2;
            if (nums[mid] == target) return mid;
            int key = (nums[mid] < nums[0]) == (target <nums[0])
                    ? nums[mid]
                    : target < nums[0] : Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (key < target) lo = mid + 1;
            else if (key == target) return mid;
            else hi = mid - 1;
        }
        return -1;
    }
}
