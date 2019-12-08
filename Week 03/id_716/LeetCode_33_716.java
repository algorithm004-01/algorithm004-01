
// https://leetcode-cn.com/problems/search-in-rotated-sorted-array
// 搜索旋转排序数组

public class LeetCode_33_716 {
    // 二分查找
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;

            // 这里是关键
            // nums[low] <= target && target < nums[mid] 表示 low mid 是有序的，且target在它们中间，需要将high向前移动
            // nums[low] > nums[mid] && target > nums[high] 表示: low ~ mid 是无序的，而且 target 比 high 位置的元素还要大，
            //                                                    因为 mid ~ high 是有序的，所以必然在 low ~ mid 中间，移动high
            // nums[low] > nums[mid] && target < nums[mid] 表示 low ~ mid 是无序的, 而且 target 比mid位置处的值还要小，
            //                                                  因为 mid ~ high 是有序的，所以必然在 low ~ mid 中间，移动high
            // 否则，就是移动low
            if ((nums[low] <= target && target < nums[mid]) 
                  || (nums[low] > nums[mid] && target > nums[high])
                  || (nums[low] > nums[mid] && target < nums[mid])) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low == high && nums[low] == target ? low : -1;
    }

    // 还有另外一种思路：先找到无序的位置，然后再使用正常的二分查找找到索引位置，这种方式暂时不实现
}