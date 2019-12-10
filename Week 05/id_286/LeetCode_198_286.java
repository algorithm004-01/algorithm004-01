package com.uanei;

public class LeetCode_198_286 {

    public int rob(int[] nums) {
        // 将一维数组变成二维数组
        // a[i][1|0] 0 表示要偷，1表示不偷
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[][] a = new int[n][2];

        a[0][0] = 0; // 不偷
        a[0][1] = nums[0]; // 要偷

        for (int i = 1; i < n; i++) {
            // i 不偷，则比较i-1偷和不偷的最大值
            a[i][0] = Math.max(a[i - 1][0], a[i - 1][1]);
            // i 要偷，则 i-1 不能偷
            a[i][1] = a[i - 1][0] + nums[i];
        }

        return Math.max(a[n - 1][0], a[n - 1][1]);
    }

    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] a = new int[n];

        a[0] = nums[0];
        a[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(a[0], a[1]);
        for (int i = 2; i < n; i++) {
            // 第i天偷的结果 = i-1 不偷 或者 i-2 偷 + 第 i 天偷的金额
            a[i] = Math.max(a[i - 1] + 0, a[i - 2] + nums[i]);
            res = Math.max(res, a[i]);
        }

        return res;
    }

}
