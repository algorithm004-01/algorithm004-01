import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-21 04:50
 **/

public class Leetcode_1091_371 {


    /**
     * 仿解2:双向 BFS
     * @author Shaobo.Qian
     * @date 2019/11/21
     * @link https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/solution/java-shuang-xiang-bfs-ji-bai-100-by-hao-shou-bu-ju/
     */
    public int shortestPathBinaryMatrix2(int[][] grid) {
        return -1;
    }
    /**
     * 仿解1:BFS
     *
     * @author Shaobo.Qian
     * @date 2019/11/21
     * @link https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/312706/JAVA-BFS
     */

    public int shortestPathBinaryMatrix1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;

        //1.定义二维数组表示在二维坐标系上八连通方向上各前进一步
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {1, -1}, {1, 1}, {-1, -1}, {-1, 1}};
        //2.定义二维数组标记每个单元格是否走过
        boolean[][] visited = new boolean[m][n];
        //3.创建容器
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[]{0, 0});
        int step = 0;
        //4.循环当前容器中所有的元素,判断是否找到目标
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pop = queue.remove();
                if (pop[0] == m - 1 && pop[1] == n - 1) return step;
                //5.八连通方向上各前进一步,找到新的节点,放入容器
                for (int k = 0; k < 8; k++) {
                    int nextX = dir[k][0] + pop[0];
                    int nextY = dir[k][1] + pop[1];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return -1;
    }
}
