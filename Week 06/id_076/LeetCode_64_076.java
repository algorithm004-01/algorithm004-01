package week05;

/**
 * 动态规划 采用二维数组
 *
 * 复杂度分析
 *  时间复杂度 ：O(mn)O(mn)。遍历整个矩阵恰好一次。
 *  空间复杂度 ：O(mn)O(mn)。额外的一个同大小矩阵。
 * @author tangzhenhua
 * @date 2019/11/17 20:51
 */
public class LeetCode_64_076 {


    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;

        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;

        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;

        LeetCode_64_076 leet = new LeetCode_64_076();
        int min = leet.minPathSum(grid);
        System.out.println(min);
    }
}
