package com.mrglint.leetcode.week02.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luhuancheng
 * @since 2019/9/5 9:33 下午
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int anotherNumber = target - nums[i];
            if (m.containsKey(anotherNumber)) {
                // 先返回前一个数的索引
                return new int[]{m.get(anotherNumber), i};
            } else {
                m.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("no such result");
    }
}

