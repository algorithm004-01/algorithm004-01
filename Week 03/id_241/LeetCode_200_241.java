import java.util.*;
/**
 * 岛屿数量
 */
public class Solution {
    /**
     * 岛屿数量(2ms)
     */
    private char[][] grid;

    public int numIslands(char[][] grid) {
        int sum = 0;
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslandsHelper(i, j);
                    sum++;
                }
            }
        }
        return sum;
    }

    private void numIslandsHelper(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;
        if (grid[i][j] == '1')
            grid[i][j] = '0';
        numIslandsHelper(i + 1, j);
        numIslandsHelper(i - 1, j);
        numIslandsHelper(i, j + 1);
        numIslandsHelper(i, j - 1);
    }

    /**
     * 岛屿数量(3ms)
     */
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    public int numIslands2(char[][] grid) {
        int sum = 0;
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslandsHelper2(i, j);
                    sum++;
                }
            }
        }
        return sum;
    }

    private void numIslandsHelper2(int i, int j) {
        if (grid[i][j] == '1') grid[i][j] = '0';
        else return;
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == '0') continue;
            numIslandsHelper2(x, y);
        }
    }
}