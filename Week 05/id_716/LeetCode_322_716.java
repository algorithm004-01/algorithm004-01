// https://leetcode-cn.com/problems/coin-change
// 322. 零钱兑换
//

public class LeetCode_322_716 {
    // 1. 暴力求解，利用回溯思想
    public int coinChange1(int[] coins, int amount) {
        // terminator
        if (amount == 0) return 0;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 不满足条件，直接忽略
            if (amount - coin < 0) continue;

            // drill down
            int subRes = coinChange1(coins, amount - coin);

            // 子问题无解，直接忽略，结束下钻
            if (subRes == -1) continue;

            // 每一层都取子问题的最小值（合并结果）
            res = Math.min(res, subRes + 1);
        }

        // 每层返回时都返回最小值
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // 2. 带备忘录的递归求解，使用备忘录减少重叠子问题的计算量，大大节省时间
    public int coinChange2(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1];
        return coinChange2(coins, amount, memo);
    }

    private int coinChange2(int[] coins, int amount, Integer[] memo) {
        // terminator
        if (amount == 0) return 0;

        if (memo[amount] != null) return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) continue;
            int subRes = coinChange2(coins, amount - coin, memo);
            if (subRes == -1) continue;
            res = Math.min(res, subRes + 1);
        }
        // 记录
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    // 3. dp
    public int coinChange3(int[] coins, int amount) {
        // state array
        // dp[i] 表示达到金额i所需要的最小硬币数
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }

        for (int i = 0; i < amount; i++) {
            for (int coin : coins) {
                if (coin <= i)
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}