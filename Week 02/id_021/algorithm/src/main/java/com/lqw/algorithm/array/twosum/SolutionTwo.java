package com.lqw.algorithm.array.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linqiwen
 */
public class SolutionTwo {

    public int[] twoSum(int[] nums, int target) {
        int[] indexs = null;
        Map<Integer, Integer> elementAndIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            elementAndIndexMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            int j;
            if (elementAndIndexMap.containsKey(temp) && (j = elementAndIndexMap.get(temp)) != i) {
                indexs = new int[2];
                indexs[0] = i;
                indexs[1] = j;
                break;
            }
        }
        return indexs;
    }

}
