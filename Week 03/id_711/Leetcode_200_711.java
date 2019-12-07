package Week3;

public class Leetcode_200_711 {

    char[][] g;
    int[] a = {0,0,1,-1};
    int[] b = {1,-1,0,0};

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        Leetcode_200_711 ss = new Leetcode_200_711();
        System.out.println(ss.numIslands(grid));
    }

    /**
     * 归零算法
     * 执行用时 :4 ms, 在所有 java 提交中击败了55.79%的用户
     * 内存消耗 :41.2 MB, 在所有 java 提交中击败了83.54%的用户
     * @param grid
     * @return
     */
    private int numIslands(char[][] grid) {
        g = grid;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (g[i][j] == '1') {
                    count++;
                    zero(i,j);
                }
            }
        }
        return count;
    }

    private void zero(int i, int j) {
        g[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + a[k];
            int y = j + b[k];
            if (x >= 0 && x < g.length && y >= 0 && y < g[0].length && g[x][y] == '1')
                zero(x, y);
        }
    }
}
