package com.uanei;

public class LeetCode_55_286 {

    /**
     * 贪心算法：从后往前，记录能够跳到最后那一个位置的第一个下标值
     * 简单理解就是，从最后位置向前看，能否到达最后
     */
    public boolean canJump(int[] nums) {
        if (nums == null) return false;

        int endReachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 如果某个位置能到达下一个位置，就往前推
            if (nums[i] + i >= endReachable) {
                endReachable = i;
            }
        }

        return endReachable == 0;
    }

}
