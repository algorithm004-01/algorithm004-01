package com.uanei;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_286 {

    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 计算当前元素需要匹配的另一元素的值，map存储 key = 需要的值，value = 当前元素的位置
            int jValue = target - nums[i];
            if (map.containsKey(nums[i])) {
                a[0] = map.get(nums[i]);
                a[1] = i;
                if (a[0] != a[1]) {
                    return a;
                }
            }
            map.put(jValue, i);
        }
        return new int[0];
    }

}
