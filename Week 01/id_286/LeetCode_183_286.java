package com.uanei;

public class LeetCode_183_286 {

    public void moveZeroes(int[] nums) {
        // 通过索引记录0元素的位置
        // 将非0元素移动到索引位置
        // （索引和当前元素索引相同，说明前边的元素没有0，如果索引小于当前索引，则前边有0元素，进行交换）
        // 交换位置之后，0元素的索引向后移一位
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                if (index != i) {
                    nums[i] = 0;
                }
                index++;
            }
        }
    }

}
