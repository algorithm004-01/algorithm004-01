class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j ++) {
                if(grid[i][j] == '1'){
                    result++;
                    dfs(i, j, grid);
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int row, int column, char[][] grid) {
        grid[row][column] = 1;
        if(row > 0 && grid[row - 1][column] == '1') {
            dfs(row - 1, column,  grid);
        }
        
        if(row < grid.length - 1 && grid[row + 1][column] == '1') {
            dfs(row + 1, column,  grid);
        }
        
        if(column > 0 && grid[row][column - 1] == '1') {
            dfs(row, column - 1,  grid);
        }
        
        if(column < grid[0].length - 1 && grid[row][column + 1] == '1') {
            dfs(row , column + 1,  grid);
        }
    }
}
