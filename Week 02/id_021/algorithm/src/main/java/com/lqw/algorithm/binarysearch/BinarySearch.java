package com.lqw.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分法
 *
 * @author linqiwen
 */
public class BinarySearch {

    public static Integer search(List<Integer> nums, Integer target) {
        if (nums == null || nums.isEmpty() || target == null) {
            return null;
        }
        int low = 0;
        int high = nums.size() - 1;
        int mid = low + (high - low) >> 2;
        while (low < high) {
            int midValue = nums.get(mid);
            if (target.equals(midValue)) {
                return midValue;
            } else if (target < midValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = low + (high - low) >> 2;
        }
        if (target.equals(nums.get(mid))) {
            return nums.get(mid);
        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        nums.add(10);
        System.out.println(search(nums, 9));
    }

}
