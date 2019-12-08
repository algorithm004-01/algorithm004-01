import java.util.LinkedList;

/**
 * Created by LynnSun on 2019/10/29.
 * 力扣题目地址：https://leetcode-cn.com/problems/number-of-islands/
 * 广度优先搜索
 */
public class NumIslands_bfs {
    // 陆地坐标
    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int count = 0, rows = grid.length;
        // X 轴可以移动到的坐标，Y 轴可以移动到的坐标
        int[] moveX = {-1, 1, 0, 0}, moveY = {0, 0, -1, 1};
        LinkedList<Point> queue = new LinkedList();
        // rows 行数
        for (int i = 0; i < rows ; i++) {
            // cols 列数
            int cols = grid[i].length;
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    // 累加岛屿的数量
                    count++;
                    // 把访问过的陆地坐标变成0（海水），再一次就不会再访问
                    grid[i][j] = '0';
                    // 添加到队列中
                    queue.add(new Point(i, j));
                    // 广度优先遍历，上下左右染色
                    while (queue.size() != 0) {
                        // 取出陆地坐标
                        Point p = queue.poll();
                        // 对其进行上下左右的坐标进行判断能否组成岛屿
                        for (int k = 0; k < moveX.length; k++) {
                            int x = p.x + moveX[k], y = p.y + moveY[k];
                            // 判断是否能组成岛屿
                            if (isValid(rows, cols, x, y) && grid[x][y] == '1') {
                                // 能组成岛屿就变成0（海水），下一次就不会再访问
                                grid[x][y] = '0';
                                queue.add(new Point(x, y));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 判断能否能移动
     * @param rows
     * @param cols
     * @param x
     * @param y
     * @return
     */
    private boolean isValid(int rows,int cols, int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        NumIslands_bfs ns = new NumIslands_bfs();
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
