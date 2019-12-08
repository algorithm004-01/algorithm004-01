import java.util.*;
/**
 * 搜索旋转排序数组
 */
public class Solution {
    /**
     * 搜索旋转排序数组
     * (0ms)
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (target >= nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * 搜索旋转排序数组
     * (将上面的判断精简一下)
     * (1ms)
     */
    private int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0]))
                left = mid + 1;
            else if (target > nums[mid] && target < nums[0])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left] == target ? left : -1;
    }
}