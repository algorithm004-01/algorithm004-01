package dynamic_programming;

/**
 * @author alis
 * @date 2019/11/17 10:54 PM
 * @description
 */
public class LeetCode_64_721 {
    /**
     * 解法：暴力遍历所有路径的和的解法就不实现了，就算实现出来也是超时；
     * 直接使用DP来实现
     * 最优dp方程：dp(i,j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1))
     * dp三部曲：
     * 1. 子问题
     * 2. 状态定义
     * 3. DP方程
     *
     * @param grid 网格
     * @return
     * @date 2019/11/17 10:55 PM
     */
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int column = grid[0].length;
        if (rows == 0 && column == 0) return 0;
        int[][] dp = new int[rows][column];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {

                if (i == rows - 1 && j != column - 1)
                    // 最后一行排除最后一列的节点([rows-1][column-1])
                    // 最后一行的路径数计算只会从上一步加过来
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                else if (j == column - 1 && i != rows - 1)
                    // 最后一列排除最后一行的节点[rows-1][column-1]
                    // 当前节点计数需要从上一个节点反推
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if (j != column - 1 && i != rows - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }

}
