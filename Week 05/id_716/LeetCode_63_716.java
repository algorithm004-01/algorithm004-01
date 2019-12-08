// https://leetcode-cn.com/problems/unique-paths-ii/
// 63. 不同路径 II

public class LeetCode_63_716 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] memo = new int[n];
        int[] memoHelper = new int[m];
        memo[0] = 1;
        memoHelper[0] = 1;

        for (int i = 1; i < n; i++)
            memo[i] = obstacleGrid[0][i] == 1 || memo[i - 1] == 0 ? 0 : 1;
        for (int i = 1; i < m; i++)
            memoHelper[i] = obstacleGrid[i][0] == 1 || memoHelper[i - 1] == 0 ? 0 : 1;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) memo[j] = memoHelper[i];
                else memo[j] = obstacleGrid[i][j] == 1 ? 0 : memo[j] + memo[j - 1];
            }
        }

        return memo[n - 1];
    }
}