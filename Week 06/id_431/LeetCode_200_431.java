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
//    public int numIslands(char[][] grid) {
//        if (grid.length <= 0) return 0;
//        int num = 0;
////        Set<String> visited = new HashSet<>();
//        int length = grid.length;
//        int height = grid[0].length;
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < height; j++) {
//                if (grid[i][j] == '1') {
//                    DFS(grid, i, j, length, height);
//                    num++;
//                }
//            }
//        }
//        return num;
//    }
//
//    public void DFS(char[][] grid, int i, int j, int length, int height){
//        if (i < 0 || j < 0 || i > length - 1 || j > height - 1 || grid[i][j] == '0') return;
//        grid[i][j] = '0';
//        DFS(grid, i - 1, j, length, height);
//        DFS(grid, i + 1, j, length, height);
//        DFS(grid, i, j - 1, length, height);
//        DFS(grid, i, j + 1, length, height);
//    }

    int[][] directions = new int[][] {
            new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}
    };

    /**
     * 使用并查集进行解题
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    int id = i * col + j;
                    for (int x = 0; x < 4; x++) {
                        int tmpi = i + directions[x][0];
                        int tmpj = j + directions[x][1];
                        if (tmpi >= 0 && tmpi < row && tmpj >= 0 && tmpj < col && grid[tmpi][tmpj] == '1') {
                            uf.unionSet(id, tmpi * col + tmpj);
                        }
                    }
                }
            }
        }
        return uf.count;
    }

    class UnionFind {
        int count;
        int[] parent;

        UnionFind (char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            parent = new int[row * col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        int id = i * col + j;
                        parent[id] = id;
                    }
                }
            }
        }

        int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        void unionSet(int p, int q) {
            int rootp = find(p);
            int rootq = find(q);
            if (rootp != rootq) {
                parent[rootp] = rootq;
                count--;
            }
        }
    }
}
