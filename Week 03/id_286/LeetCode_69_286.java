package com.uanei;

public class LeetCode_69_286 {

    /**
     * 二分查找
     */
    public int mySqrt1(int x) {
        // 边界情况判断
        if (x == 0 || x == 1) {
            return x;
        }

        long left = 1;
        long right = x;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            if (mid * mid > x) {
                // mid 比较大，往左边找
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return (int) left;
    }

    /**
     * 牛顿迭代法：数学公式计算
     */
    public int mySqrt2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long r = x;

        while (r * r > x) {
            r = (r + x / r) / 2;
        }

        return (int)r;
    }

}
