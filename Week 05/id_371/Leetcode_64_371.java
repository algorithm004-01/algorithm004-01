/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-17 22:46
 **/

public class Leetcode_64_371 {
    public static void main(String[] args) {

    }

    /**
     * 仿解1:dp-->自顶向下(循环+记忆化存储)
     *
     * @author Shaobo.Qian
     * @date 2019/11/17
     * @link https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
     * @anki 1.dp 方程如何推导 2.如何降维度
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }
}
