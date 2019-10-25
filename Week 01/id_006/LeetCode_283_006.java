package com.mrglint.leetcode.solution283;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 * @author luhuancheng
 * @since 2019-10-16 06:55
 */
public class Solution {

    public void moveZeroes1(int[] nums) {
        // 指向非0位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        int notZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[notZeroIndex];
                nums[notZeroIndex] = nums[i];
                nums[i] = temp;
                notZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{1, 0, 1, 2};
        solution.moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }

}

