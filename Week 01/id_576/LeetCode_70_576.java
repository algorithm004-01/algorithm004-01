/*
1.升维的思想，时间换空间
2.最大误区：刷题只刷一遍
3. 形成肌肉记忆

 */


class _70ClimbStaira {

    //暴力法：斐波那契额数列
    //f(n) = f(n-1) + f(n-2)
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        } 
        
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * 方法二：dynamic programming
     * 第 ii 阶可以由以下两种方法得到：

在第 (i-1)(i−1) 阶后向上爬一阶。

在第 (i-2)(i−2) 阶后向上爬 22 阶。

所以到达第 ii 阶的方法总数就是到第 (i-1)(i−1) 阶和第 (i-2)(i−2) 阶的方法数之和。

令 dp[i]dp[i] 表示能到达第 ii 阶的方法总数：

dp[i]=dp[i-1]+dp[i-2]
dp[i]=dp[i−1]+dp[i−2]

     */
    public int climbStairs2 (int n) {
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

    /**
     * Basically it's a fibonacci
     * r if we look at it closer, it is clear that this is basically a fibonacci number, 
     * with the starting numbers as 1 and 2, instead of 1 and 1.
     */
    public int climbStairs(int n) {
        //base cases
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int one_step_before = 2;
        int two_step_before = 1;
        int all_ways = 0;

        for (int i = 2; i < n; i++) {
            all_ways = one_step_before + two_step_before;
            two_step_before = one_step_before;
            one_step_before = all_ways;// keep updating two/one step ways
        }
        return all_ways;
    }

} 