package sf.week8;

/**
 * Created by LynnSun on 2019/12/6.
 * 力扣题目地址：https://leetcode-cn.com/problems/unique-paths-ii
 */
public class UniquePathsTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 第一个数
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        if (dp[0][0] == 0) return 0;
        // 第一行
        for (int j = 1; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] != 1) {
                dp[0][j] = dp[0][j - 1];
            }
        }
        // 第一列
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] != 1) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
