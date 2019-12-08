package com.lzhlyle.leetcode.self.no153;

public class FindMinimumInRotatedSortedArray_2 {
    public int findMin(int[] nums) {
        // base condition
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0];

        // binary search: compare right
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) right = mid;
            else left = mid + 1;
        }
        return nums[left];
    }
}
