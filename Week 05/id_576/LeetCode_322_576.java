import java.util.Arrays;

/**
 * LeetCode_322_576
 */
public class LeetCode_322_576 {

    /** 其实与爬楼梯问题类似
     * 1. 暴力法：递归：指数级
     * 2. BFS
     * 3. DP
     *  a. subproblems
     *  b. DP array : 
     *  c. DP方程
     */

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}