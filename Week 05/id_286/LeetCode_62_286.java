package com.uanei;

public class LeetCode_62_286 {

    public int uniquePaths(int m, int n) {
        // 递归 -- 自顶向下
        // 动态规划 -- 自底向上，从一个开始就推导结果和最优
        // dp[i][j] 表示第i，j的位置的有多少中结果
        int[][] dp = new int[m][n];
        // 初始化第一行为1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 初始化第一列的所有行为1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // 初始化结果如下
//        [x,x,x,x,x,1]
//        [x,x,x,x,x,1]
//        [x,x,x,x,x,1]
//        [x,x,x,x,x,1]
//        [x,x,x,x,x,1]
//        [1,1,1,1,1,finish]

        // i = 1 是从右下角开始向上，第一行已经初始化了，不需要计算
        // 从计算第二行开始，列也是一样的，从第二列开始，即索引下标为 1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 指定节点的走法 = 下边格子的走法 + 右边格子的走法
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

}
