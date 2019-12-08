package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/11/1
 */
public class NumberOfIslands {
    /**
     * DFS
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid.length <= 0) return 0;
        int num = 0;
//        Set<String> visited = new HashSet<>();
        int length = grid.length;
        int height = grid[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] == '1') {
                    DFS(grid, i, j, length, height);
                    num++;
                }
            }
        }
        return num;
    }

    public void DFS(char[][] grid, int i, int j, int length, int height){
        if (i < 0 || j < 0 || i > length - 1 || j > height - 1 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        DFS(grid, i - 1, j, length, height);
        DFS(grid, i + 1, j, length, height);
        DFS(grid, i, j - 1, length, height);
        DFS(grid, i, j + 1, length, height);
    }
}
