package com.lzhlyle.leetcode.self.no55;

public class JumpGame_2 {
    // 1ms
    public boolean canJump(int[] nums) {
        // base condition
        if (nums == null || nums.length < 1) return false;
        if (nums.length == 1) return true;

        // greedy, backward
        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= last) last = i;
        }
        return last == 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 0};
        boolean can = new JumpGame_2().canJump(nums);
        System.out.println(can);
    }
}
