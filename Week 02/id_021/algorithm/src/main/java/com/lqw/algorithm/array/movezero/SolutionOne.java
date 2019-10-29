package com.lqw.algorithm.array.movezero;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * <p>
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * <p>
 * 定义一个新数组，加上两个下标,start存储非0，end位置开始存储0
 *
 * @author linqiwen
 */
public class SolutionOne {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        int[] newNums = new int[length];

        int start = 0;
        int end = length - 1;

        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                newNums[start] = nums[i];
                start++;
            } else {
                newNums[end] = nums[i];
                end--;
            }
        }
        System.out.println(Arrays.toString(newNums));
    }

    public static void main(String[] args) {
        SolutionOne solutionOne = new SolutionOne();
        int[] nums = new int[]{0,1,0,3,12};
        solutionOne.moveZeroes(nums);
    }

}


