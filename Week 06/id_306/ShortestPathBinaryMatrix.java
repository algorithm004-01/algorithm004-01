package sf.week6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by LynnSun on 2019/11/24.
 * 力扣题目地址：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 */
public class ShortestPathBinaryMatrix {

    /**
     * 注释好理解版
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 当矩阵第一个元素为1或者最后一个元素为1时，直接返回-1
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1) return -1;
        grid[0][0] = 1;
        // 创建队列用于保存每一格可以走的步
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0, 0});
        // 队列长度,c要和队列做对比,知道何时到达队列长度
        int len = q.size();
        int c = 0;
        // 定义八个方向
        int[][] dir = {{1, 0}, {1, 1}, {1,-1}, {0, 1}, {0, -1}, {-1, 0},{-1, -1}, {-1, 1}};
        // 定义最短路径长度
        int path = 1;
        while(!q.isEmpty()){
            int[] data = q.poll();
            // x、y代表当前的坐标（x，y）
            int x = data[0];
            int y = data[1];
            // 如果走到最后一格，返回
            if(x == m - 1 && y == n - 1) return path;
            // 此处填充队列，将可走的步添加进队列
            for(int[] d : dir){
                // x1，y1代表当前坐标移动后的坐标（x1，y1）
                int x1 = x + d[0];
                int y1 = y + d[1];
                if(x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && grid[x1][y1] == 0){
                    q.add(new int[]{x1, y1});
                    grid[x1][y1] = 1;
                }
            }
            c++;
            if(c == len){
                c = 0;
                path++;
                len = q.size();
            }
        }
        return -1;
    }
}
