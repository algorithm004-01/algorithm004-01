package com.sslz.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */

public class leetcode_1 {
    /**
     * 解法一  暴力解法   scala 语言
     * 时间复杂度 O(N^2)
     */
    /*
    def solution_01(nums: Array[Int], target: Int): Array[Int] = {
        var array =new  Array[Int](2)
        for (i <- 0 to nums.length - 1) {
            for (j <- i+1 to nums.length - 1) {
                if (nums(i) + nums(j) == target) {
                    array(0)=i
                    array(1)=j
                }
            }
        }
        array
    }
    */

    /**
     * 解法二  采用hash
     * 时间复杂度 O(N^3)
     */
    public int[] solution_02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {
                        map.get(target - nums[i]), i
                };
            }
            // 值 为 key ，下标为 value
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
