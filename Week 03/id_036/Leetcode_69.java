package com.sslz.leetcode.Week3;

public class Leetcode_69 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 0;
        //最大边界问题
        long right = Integer.MAX_VALUE;
        while (left < right) {

            // 这里因为是正整数 所以采用的  >>>   或  >> 是一样的性质  如果包含负数则 大不一样
            //(left + right + 1) >> 1  而不是(left + right) >> 1 这里的  1 是干嘛的
            long mid = (left + right + 1) >> 1;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) right;
    }

    // 牛顿法
    public int mySqrt01(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }


}
