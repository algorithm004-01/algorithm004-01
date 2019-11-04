package com.mrglint.leetcode.solution189;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-10-17 13:19
 */
public class Solution {

    /**
     暴力破解 - 写法1，时间复杂度 O(n * k)
     *
     */
    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int choose = nums[nums.length - 1];
            int j = nums.length - 1;
            while (j > 0) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = choose;
        }
    }

    /**
     暴力破解 - 写法2，时间复杂度 O(n * k)
     *
     */
    public void rotate2(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * (index + number) % array.length 可以取得index索引所在元素，往右移动number次
     使用额外数组， 时间复杂度O(n)
     *
     */
    public void rotate3(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < a.length; i++) {
            nums[i] = a[i];
        }

    }

    public void rotate4(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            // 下一个要被替换位置的指针
            int next = (start + k) % nums.length;
            // previous保存放入下一个替换位置的值
            int previous = nums[start];
            while (next != start) {
                // temp保存被替换的数组元素
                int temp = nums[next];
                nums[next] = previous;
                previous = temp;
                // 下一次替换位置
                next = (next + k) % nums.length;
                count++;
            }
            // 将最后一个值放入原点位置
            nums[start] = previous;
            count++;
        }
    }

    public void rotate(int[] nums, int k) {
        // 1, 2, 3, 4, 5 -> 5, 4, 3, 2, 1 -> 4, 5, 3, 2, 1 -> 4, 5, 1, 2, 3
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

