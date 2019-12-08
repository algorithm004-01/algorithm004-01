package com.uanei;

public class LeetCode_33_286 {

    /**
     * 二分查找：通过二分和收敛
     * 本题的关键点是时间复杂度，必须是o(logN)级别的
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            // 如果0到mid有序，则向后规约
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                low = mid + 1;
            }
            // 如果0到mid无序，则说明发生了旋转，如果不在0到mid中，则向后规约
            else if (target > nums[mid] && target < nums[0]) {
                low = mid + 1;
            }
            // 向前规约
            else {
                high = mid;
            }
        }

        // 找到了返回位置索引，没有找到，直接返回-1
        return low == high && nums[low] == target ? low : -1;
    }

}
