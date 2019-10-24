package com.first;

import java.util.*;

public class ThreeSum {
    public Set<List> threeSum(int[] nums) {
        Set<List> resultList = new HashSet<List>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        //list值排序
                        Collections.sort(list);
                        resultList.add(list);
                        resultList.contains(list);
                    }
                }
            }
        }
        return resultList;
    }

    //双指针法，时间复杂度为n^2
    public List<List<Integer>> threeSumDouble(int[] nums) {
        Arrays.sort(nums);
        List resultList = new ArrayList();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int k = i + 1, l = nums.length - 1; k < l; ) {
                int resultValue = nums[i] + nums[k] + nums[l];
                if (resultValue < 0) {
                    k++;
                }
                if (resultValue > 0) {
                    l--;
                }
                if (resultValue == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[k], nums[l]));
                    while (k < l && nums[k] == nums[k + 1]) k++;
                    while (k < l && nums[l] == nums[l - 1]) l--;
                    k++;
                    l--;
                }

            }
        }
        return resultList;
    }
}
