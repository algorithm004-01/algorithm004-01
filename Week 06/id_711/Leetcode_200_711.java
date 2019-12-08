package Week6;

class UnionFindLand {
    public int count;
    public int[] parent;

    public UnionFindLand(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        parent = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    parent[i * m + j] = i * m + j;
                    count++;
                }
            }
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
            count--;
        }
    }
}

public class Leetcode_200_711 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(new Leetcode_200_711().numIslands(grid));
    }

    int[] a = {0,0,1,-1};
    int[] b = {1,-1,0,0};

    /**
     * 并查集写法
     * 执行用时 :5 ms, 在所有 java 提交中击败了36.97%的用户
     * 内存消耗 :41.3 MB, 在所有 java 提交中击败了82.09%的用户
     * @param grid
     * @return
     */
    private int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        UnionFindLand union = new UnionFindLand(grid);
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + a[k];
                        int y = j + b[k];
                        if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '1') {
                            union.union(i * m + j, x * m + y);
                        }
                    }
                }
            }
        }
        return union.count;
    }


}
