package com.yiche;

/**
 * @auther: TKQ
 * @Title: MoveZeroes_283
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-10-20 17:32
 */
public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                if (zeroCount > 0) {
                    nums[i - zeroCount] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
}
//runtime:0 ms
//memory:37.6 MB