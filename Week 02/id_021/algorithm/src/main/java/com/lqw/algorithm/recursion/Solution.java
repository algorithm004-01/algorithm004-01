package com.lqw.algorithm.recursion;


import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 *
 * 解题思路：
 * f(3) = f(2) + f(1)
 *
 * 转换f（n）= f(n - 1) + f(n - 2) 斐波数列
 *
 * 1、暴力破解，使用递归
 * 2、使用递归加哈希表
 * 3、动态规划
 * 4、使用斐波拉却
 */
class Solution {

    public int climbStairs(int n) {
        if (n < 1) {
            return -1;
        }
        Map<Integer, Integer> tempDataMap = new HashMap<>(n / 2);
        tempDataMap.put(1, 1);
        tempDataMap.put(2, 2);
        //自顶向下编程
        return resur(n, tempDataMap);
    }

    //使用哈希表法，时间复杂度O（n）
    private int resur(int n, Map<Integer, Integer> tempDataMap) {
        if (n <= 2) {
            return n;
        }

        Integer oneValue = tempDataMap.get(n - 1);
        Integer twoValue = tempDataMap.get(n - 2);

        if (oneValue == null) {
            oneValue = resur(n - 1, tempDataMap);
            tempDataMap.put(n - 1, oneValue);
        }

        if (twoValue == null) {
            twoValue = resur(n - 2, tempDataMap);
            tempDataMap.put(n - 2, twoValue);
        }

        return oneValue + twoValue;
    }

    //使用动态规划
    private int dynamicPlan(int n) {
        if (n <= 2) {
            return n;
        }
        int[] datas = new int[n + 1];
        datas[1] = 1;
        datas[2] = 2;
        for (int i = 3; i <= n; i++) {
            datas[i] = datas[i - 1] + datas[i - 2];
        }
        return datas[n];
    }

    //斐波那契数
    private int fib(int n) {
        if (n <= 2) {
            return n;
        }

        int tempOne = 1;
        int tempTwo = 2;

        for (int i = 3; i <= n; i++) {
            int temp = tempOne + tempTwo;
            tempOne = tempTwo;
            tempTwo = temp;
        }

        return tempTwo;
    }


    public static void main(String[] args) {

        int n = Integer.valueOf(args[0]);
        System.out.println(test1(n));
        System.out.println(test2(n));
        System.out.println(test3(n));

    }

    //使用哈希表法
    private static int test1(int n) {
        Solution solution = new Solution();
        return solution.climbStairs(n);
    }

    //使用动态规划
    private static int test2(int n) {
        Solution solution = new Solution();
        return solution.dynamicPlan(n);
    }

    //斐波那契数
    private static int test3(int n) {
        Solution solution = new Solution();
        return solution.fib(n);
    }

}
