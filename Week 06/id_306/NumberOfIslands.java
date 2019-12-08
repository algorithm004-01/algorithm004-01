package sf.week6;

/**
 * Created by LynnSun on 2019/11/23.
 * 力扣题目地址：https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    class Union{
        private int[] union;
        int count = 0;
        Union(char[][] grid){
            int len1 = grid.length, len2 = grid[0].length;
            union = new int[len1 * len2];
            // 初始化并查集
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    if (grid[i][j] == '1') {
                        int index = i * len2 + j;
                        union[index] = index; // 初始化指向自己
                        count++;
                    }
                }
            }
        }
        // 找到终点
        int find(int index) {
            if (union[index] == index) {
                return index;
            }
            int end = find(union[index]);// 递归查找
            while (union[index] != end) { // 优化并查集合并
                int temp = index;
                index = union[index];
                union[temp] = end;
            }
            return  end;
        }
        // 合并并查集
        void union(int index1,int index2){
            int end1 = find(index1);
            int end2 = find(index2);
            if (end1 != end2) { // 不是同一终点
                union[end2] = end1; // 合并
                count--; // 岛屿数 -1
            }
        }

    }
    private int[] moveX = {-1, 1, 0, 0},moveY = {0, 0, -1, 1};

    /**
     * 并查集方式
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        Union union = new Union(grid);
        int len1 = grid.length;
        for (int i = 0; i < len1; i++) {
            int len2 = grid[0].length;
            for (int j = 0; j < len2; j++) {
                if (grid[i][j] == '1') { // 将上下左右的 1 合并在一起
                    for (int k = 0; k < moveX.length; k++) {
                        int x = i + moveX[k], y = j + moveY[k];
                        if (isValid(grid, len1, len2, x, y)) {
                            union.union(i * len2 + j, x * len2 + y);
                        }
                    }
                }
            }
        }
        return union.count;
    }


    private boolean isValid(char[][] grid,int len1,int len2, int x, int y) {
        return x >= 0 && x < len1 && y >= 0 && y < len2 && grid[x][y] == '1';
    }
}
