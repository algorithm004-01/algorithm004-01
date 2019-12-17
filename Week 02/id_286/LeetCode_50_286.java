package com.uanei;

public class LeetCode_50_286 {

    /**
     * 循环计算
     */
    public double myPow1(double x, int n) {
        // 边界问题，如果n是负数
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }

        double re = 1;
        for (long i = 0; i < N; i++) {
            re = re * x;
        }

        return re;
    }

    /**
     * 分治递归o(logn)
     */
    public double myPow(double x, int n) {
        // 处理边界问题
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        // 边界条件 n = 0
        if (n == 0) {
            return 1.0;
        }

        // 分治：分成两半计算
        double half = fastPow(x, n / 2);

        //偶数恰好分成两半，但是奇数个的话，就说明还有一个需要乘
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

}
