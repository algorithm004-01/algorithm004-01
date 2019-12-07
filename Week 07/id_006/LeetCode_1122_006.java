package com.mrglint.leetcode.week07.solution1122;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-11-28 21:34
 */
public class Solution {
    /**
     * 1. 开辟1001大小的数组空间，记为cache
     * 2. 遍历arr1，进行计数
     * 3. 遍历arr2，作为索引到cache中获取值
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1.length == 0) {
            return arr1;
        }
        int[] cache = new int[Arrays.stream(arr1).max().getAsInt() + 1];
        for (int i : arr1) {
            cache[i]++;
        }
        int[] res = new int[arr1.length];
        int index = 0;
        // arr2的顺序
        for (int i : arr2) {
            while (cache[i] > 0) {
                res[index++] = i;
                cache[i]--;
            }
            cache[i] = 0;
        }

        // 剩余的arr1,需要由小到大排列
        for (int i = 0; i < cache.length; i++) {
            while (cache[i] > 0) {
                res[index++] = i;
                cache[i]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6});
        System.out.println(Arrays.toString(ints));
    }



}

