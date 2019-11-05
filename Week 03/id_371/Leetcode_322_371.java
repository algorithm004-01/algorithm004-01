import java.util.Arrays;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-02 17:36
 **/

public class Leetcode_322_371 {
    public static void main(String[] args) {
//        int[] coins = {186, 419, 83, 408};
//        int[] coins = {1};
//        int[] coins = {1,2,5};
        int[] coins = {2};
//        int amount = 6249;
//        int amount = 11;
        int amount = 3;
//        int amount = 1;
        int count = coinChange2(coins, amount);
        System.out.println("count = " + count);

    }


    /**
     * 仿解2:动态规划(自底向上)
     * @author Shaobo.Qian
     * @date 2019/11/3
     */
    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin]);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min+1;
        }

        return dp[amount];
    }
    /**
     * 仿解1:动态规划(自顶向下)
     * @author Shaobo.Qian
     * @date 2019/11/3
     */
    public static int coinChange1(int[] coins, int amount) {
        if (amount<1) return 0;
        int[] count = new int[amount];

        return helper(coins,amount,count);
    }

    private static int helper(int[] coins, int rem, int[] count) {
        //1.递归出口
        if(rem <0) return -1; //invalid
        if(rem == 0) return 0;//completed
        //如果计算过的结果
        if(count[rem-1]!= 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        //2.处理当前层(动态规划的方式处理)
        for (int coin : coins) {
            //3.带上参数,去下一层
            int res = helper(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        //处理当前层结果,并返回
        count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem - 1];
    }

    /**
    /**
     * 原解1:(未解出)
     * @author Shaobo.Qian
     * @date 2019/11/3
     */
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount >= coins[i]) {
                count += amount / coins[i];
                amount %= coins[i];
                if (amount == 0) return count;
            }
        }
        return -1;
    }

}
