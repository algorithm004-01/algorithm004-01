package com.sslz.leetcode;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class leetcode_283 {

    public  int[] solution_01(int[] nums) {
        if (nums.length == 0) return null;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[temp] = nums[i];
                temp++;
            }
        }
        for (int t = temp; t < nums.length; t++) {
            nums[t] = 0;
        }
        return nums;
    }
}
