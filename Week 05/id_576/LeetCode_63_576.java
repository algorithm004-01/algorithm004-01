/**
 * LeetCode_63_576
 */
public class LeetCode_63_576 {
    //1. 并不是最简洁的，但是我觉得逻辑很清晰
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;//感觉这句都可以不写，本来就是0
                //on the first column, if there is an obstacle, the rest are blocked. 
			    //no need to continue.
                break;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                break;
            } else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[row-1][col-1];
    }

    //2.试着写的更简洁
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } 
                else if (i==0 || j==0){
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        } 
        return dp[row-1][col-1];
    }
}


