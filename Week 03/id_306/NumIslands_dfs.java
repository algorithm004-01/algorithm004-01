/**
 * Created by LynnSun on 2019/10/28.
 * 力扣题目地址：https://leetcode-cn.com/problems/number-of-islands/
 * 深度优先搜索
 */
public class NumIslands_dfs {
    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private int[] moveX = {-1, 1, 0, 0},moveY = {0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int count = 0, len1 = grid.length;

        for (int i = 0; i < len1; i++) {
            int len2 = grid[i].length;
            for (int j = 0; j < len2; j++) {
                // 每次返回的岛屿数量总和
                count += dfs(grid, len1, len2, i, j);
            }
        }
        return count;
    }
    // 深度优先模式，递归方式遍历
    private int  dfs(char[][] grid,int len1,int len2,int x,int y) {
        if ((!isValid(len1, len2, x, y))||grid[x][y]!='1') {
            return 0;
        }
        grid[x][y] = '0';
        // 循环并递归是否能连成一个岛屿
        for (int i = 0; i < moveX.length; i++) {
            dfs(grid,len1, len2, x + moveX[i], y+moveY[i]);
        }
        return 1;
    }

    private boolean isValid(int len1,int len2, int x, int y) {
        return x >= 0 && x < len1 && y >= 0 && y < len2;
    }

    public static void main(String[] args) {
        NumIslands_dfs ns = new NumIslands_dfs();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = ns.numIslands(grid1);
        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = ns.numIslands(grid2);
        System.out.println(numIslands2);
    }
}
