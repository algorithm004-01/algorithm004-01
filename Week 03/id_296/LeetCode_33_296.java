/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (target == nums[mid]) {
				return mid;
			}
            //左半段是有序的
			if (nums[start] <= nums[mid]) {
                // 如果target在这段里，那么就继续在这找，不然丢弃
				if (target >= nums[start] && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
            //右半段是有序的
			} else {
                //如果target在这段里，那么就继续在这找，不然丢弃
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
    }
}
// @lc code=end

