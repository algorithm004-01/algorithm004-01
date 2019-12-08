package Week5;

public class Leetcode_64_711 {
    public static void main(String[] args) {
        int[][] grid = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        System.out.println(minPathSum(grid));
    }

    /**
     * f[i][j] = min(f[i - 1][j],f[i][j - 1]) + grid[i][j];
     * 执行用时 :3 ms, 在所有 java 提交中击败了91.94%的用户
     * 内存消耗 :40 MB, 在所有 java 提交中击败了84.28%的用户
     * @param grid
     * @return
     */
    private static int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] f = new int[n][m];
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            f[0][i] = f[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                f[i][j] = Math.min(f[i][j - 1],f[i - 1][j]) + grid[i][j];
            }
        }
        return f[n - 1][m - 1];
    }
}
