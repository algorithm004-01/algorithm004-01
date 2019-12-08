package com.lqw.algorithm.array.movezero;

/**
 * @author linqiwen
 */
public class SolutionThree {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int notZeroNumber = 0;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZeroNumber++] = nums[i];
            }
        }
        for (int i = notZeroNumber; i < length; i++) {
            nums[notZeroNumber] = 0;
        }
    }
}
