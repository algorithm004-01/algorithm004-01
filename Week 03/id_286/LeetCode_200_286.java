package com.uanei;

public class LeetCode_200_286 {

    // 构建一个坐标中的上下左右
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    char[][] g;

    /**
     * dfs 深度优先的算法，判断周围的1
     */
    public int numIslands(char[][] grid) {
        // 初始化岛屿的数量
        int islands = 0;
        // g是临时网格，岛屿会被打掉变成水
        g = grid;

        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                // 遇到水不处理
                if (g[i][j] == '0') continue;

                // g[i][j] = '1' 表示陆地
                // 遇到1，岛屿，需要通过dfs，深度优先，递归的方式打掉
                islands += sink(i, j);
            }
        }

        return islands;
    }

    private int sink(int i, int j) {
        if (g[i][j] == '0') {
            return 0;
        }

        // 打掉1
        g[i][j] = '0';

        // 上下左右挨着的位置是1也需要被打掉
        for (int k = 0; k < dx.length; k++) {
            // 坐标中的位置
            int x = i + dx[k], y = j + dy[k];
            // 数组下标是大于等于0的
            if (x >= 0 && x < g.length && y >= 0 && y < g[i].length) {
                if (g[x][y] == '0') continue;

                // 还需要检查相邻的1的周围是否有1
                sink(x, y);
            }
        }

        // 一个岛屿被打掉之后，计数
        return 1;
    }

}
