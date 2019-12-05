import java.util.*;
/**
 * 寻找旋转排序数组中的最小值
 */
public class Solution {
    /**
     * 寻找旋转排序数组中的最小值
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (left + 1 == right) {
                if (nums[right] > nums[left]) return nums[left];
                break;
            }
            int mid = (left + right) >> 1;
            if (nums[mid] < nums[right]) right = mid;
            else left = mid;
        }
        return nums[right];
    }
}