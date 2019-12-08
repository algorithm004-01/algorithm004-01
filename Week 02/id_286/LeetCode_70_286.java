package com.uanei;

public class LeetCode_70_286 {

    /**
     * 解法一：循环求解
     */
    public int climbStairs1(int n) {
        // 1: 1
        // 2: 2
        // 3: f(3) = f(1) + f(2) => 要么再爬2梯，要么再爬1梯，前边的可能性都是累加的
        // 4： f(4) = f(2) + f(3)
        // n: f(n) = f(n-1) + f(n-2) => Fibonacci数列问题
        if (n <= 2) {
            return n;
        }

        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= n; i++) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }

    /**
     * 递归求解：傻递归和记忆化递归（优化）
     */
    public int climbStairs2(int n) {
        // 1: 1
        // 2: 2
        // 3: f(3) = f(1) + f(2) => 要么再爬2梯，要么再爬1梯，前边的可能性都是累加的
        // 4： f(4) = f(2) + f(3)
        // n: f(n) = f(n-1) + f(n-2) => Fibonacci数列问题

        int[] memory = new int[n + 1];
        return climb_stairs(0, n, memory);
    }

    /**
     * @param i      当前阶数
     * @param n      目标阶数
     * @param memory 每一步的结果记忆
     */
    private int climb_stairs(int i, int n, int[] memory) {
        // 爬完了
        if (i > n) {
            return 0;
        }

        // 正好爬上来
        if (i == n) {
            return 1;
        }

        // 看看历史中是否存在爬到当前阶树的种数
        if (memory[i] > 0) {
            return memory[i];
        }

        // 记忆
        // 爬到当前楼梯的可能是：要么-1爬一步，要么-2爬两步
        memory[i] = climb_stairs(i + 1, n, memory) + climb_stairs(i + 2, n, memory);

        // 返回爬到当前阶梯的可能数
        return memory[i];
    }

}
