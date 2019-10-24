package com.yiche;

/**
 * @auther: TKQ
 * @Title: ClimbStairs_70
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-10-20 17:25
 */
public class ClimbStairs_70 {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
//runtime:0 ms
//memory:32.8 MB
