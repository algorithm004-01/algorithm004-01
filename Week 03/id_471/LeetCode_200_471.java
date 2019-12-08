class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        int path[][] = new int[][]{{0, -1}, {0,1}, {1,0}, {-1,0}};
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(i, j, grid, path);
                }
            }
        }
        
        return num;
    }
    
    public void dfs(int x, int y, char[][] grid, int[][] path) {
        //terminator
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        for (int i = 0; i < path.length; i++){
            dfs(x + path[i][0], y + path[i][1], grid, path);
        }
    }
}