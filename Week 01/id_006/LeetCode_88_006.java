package com.mrglint.leetcode.solution88;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-10-19 07:48
 */
public class Solution {

    /**
     * 简单解法
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * nums1作为输出数组，将数组nums1中的前m个元素拷贝出来，之后用两个指针分别指向nums1_copy、nums2的开头，比对大小之后放入nums1中
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            nums1[k++] = nums1Copy[i] < nums2[j] ? nums1Copy[i++] : nums2[j++];
        }

        if (i < m) {
            System.arraycopy(nums1Copy, i, nums1, k, m - i);
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, k, n - j);
        }
    }

    /**
     * 从后往前合并
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 指向合并后数组的末尾
        int p = (m + n) - 1;
        // 指向nums1的末尾
        int i = m - 1;
        // 指向nums2的末尾
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[p--] = nums1[i--];
            } else {
                nums1[p--] = nums2[j--];
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }

}

