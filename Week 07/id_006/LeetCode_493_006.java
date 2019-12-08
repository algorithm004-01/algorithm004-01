package com.mrglint.leetcode.week07.solution493;

/**
 * @author luhuancheng
 * @since 2019-11-29 07:59
 */
public class Solution {
    private int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(0, nums.length - 1, nums);
        return count;
    }

    private void mergeSort(int lo, int hi, int[] nums) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + ((hi - lo) >> 1);
        mergeSort(lo, mid, nums);
        mergeSort(mid + 1, hi, nums);
        merge(lo, mid, hi, nums);
    }

    private void merge(int lo, int mid, int hi, int[] nums) {
        // 统计 nums[i] > 2 * nums[j]; j ∈ [mid + 1, hi] 的个数
        for (int m = lo; m <= mid; m++) {
            int n = mid + 1;
            while (n <= hi && nums[m] > (long) 2 * nums[n]) {
                n++;
            }
            count += n - (mid + 1);
        }

        int i = lo;
        int j = mid + 1;
        int k = 0;

        // 临时数组
        int[] temp = new int[hi - lo + 1];
        while (i <= mid && j <= hi) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= hi) {
            temp[k++] = nums[j++];
        }

        // 拷贝回原数组
        System.arraycopy(temp, 0, nums, lo, hi - lo + 1);
    }
}

