package com.uanei;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_286 {

    /**
     * hash：a + b = target --> b = target - a
     * 1 第一遍遍历将所有元素存储到map中，并记录value位置为索引
     * 2 第二次循环，判断是否满足条件，且通过索引排除相同位置的元素
     */
    public int[] twoSum(int[] nums, int target) {
        // key 是元素，value 元素的索引（即位置）
        Map<Integer, Integer> map = new HashMap<>();

        // 将所有元素放到map中并记录位置
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // 再次遍历元素，计算并排除是同一个元素的情况
        for (int i = 0; i < nums.length; i++) {
            // b = target -a
            int b = target - nums[i];
            if (map.containsKey(b) && map.get(b) != i) {
                return new int[]{i, map.get(b)};
            }
        }

        throw new RuntimeException("no solution");
    }

}
