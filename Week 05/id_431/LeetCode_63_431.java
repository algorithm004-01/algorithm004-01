package medium;

/**
 * @author 潘磊明
 * @date 2019/11/11
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        int[] paths = new int[m];
        // init path
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) paths[i] = 0;
            else if (i == 0) paths[i] = 1;
            else paths[i] = Math.min(paths[i - 1], 1);
        }
        // DP程序
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) paths[j] = 0;
                else if (j == 0) paths[j] = Math.min(paths[j], 1);
                else paths[j] = paths[j] + paths[j - 1];
            }
        }
        return paths[m - 1];
    }
}
