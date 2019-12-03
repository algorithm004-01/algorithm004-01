package com.uanei;

public class LeetCode_322_286 {

    public int coinChange(int[] coins, int amount) {
        // f(s)= f(s-c)+1 表示对于金额s最少的硬币数
        // 其中c表示最后一枚硬币的面值，如果 s-c = 0，则 + 1 表示s的金额需要一枚硬币表示
        // 解法：自顶向下的动态规划
        if (amount < 1) return 0;
        else return change(coins, amount, new int[amount]);
    }

    // 分治子问题
    // 定义状态
    // dp方程

    /**
     * @param coins 硬币
     * @param rem   剩余金额
     * @param count
     * @return
     */
    private int change(int[] coins, int rem, int[] count) {
        // 无法完整表示金额，所以返回-1
        if (rem < 0) return -1;
        // 如果恰好能表示完金额，返回0
        if (rem == 0) return 0;
        // 从历史记忆当中查看当前金额的表示结果
        // 因为int数组默认是0，所以如果不等于0，则说明有历史存储记录
        if (count[rem - 1] != 0) return count[rem - 1];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 子结构继续递归
            int res = change(coins, rem - coin, count);
            // 等于0，表示刚好能表示完金额
            // 大于0，则表示子结果能用res个硬币表示
            // 最后将子结果和当前存储的最小硬币数进行比较，如果res比历史最小硬币数还小，则更新最小结果
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }

        // 存储当前金额的最小硬币数量
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;

        // rem-1 是因为为了在数组中记忆金额，且数组长度为rem，则最大下标为rem-1
        return count[rem - 1];
    }

}
