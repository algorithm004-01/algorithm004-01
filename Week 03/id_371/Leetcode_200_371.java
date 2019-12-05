/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-31 12:02
 **/

public class Leetcode_200_371 {
    public static void main(String[] args) {
        char[][] grid = {{'1', '0', '1', '1', '0', '1', '1'}};
        int count = numIslands(grid);
        System.out.println("count = " + count);

    }

    /**
     * 原解1:DFS
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        //把1变为0需要多少次
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    zeroGrid(i, j, grid);
                }
            }
        }
        return count;
    }

    private static void zeroGrid(int i, int j, char[][] grid) {
        int nLine = grid.length;
        int nColumn = grid[0].length;
        //1.递归出口
        if (i < 0 || j < 0 || i >= nLine || j >= nColumn || grid[i][j] == '0') return;
        //2.处理当前层
        grid[i][j] = '0';
        //3.带上参数去下一层
        //同一层,向左
        zeroGrid(i, j - 1, grid);
        //同一层,向右
        zeroGrid(i, j + 1, grid);
        //同一列,向上
        zeroGrid(i - 1, j, grid);
        //同一列,向下
        zeroGrid(i + 1, j, grid);
        //4.清理当前层
    }

}
