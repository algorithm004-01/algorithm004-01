class Solution {
    public int climbStairs(int n) {
        //递归思路，f(n) = f(n-1) + f(n-2);
        //动态规划解法
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}