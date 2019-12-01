    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 && j > 0) grid[i][j] += grid[i][j-1];
                if(j == 0 && i > 0) grid[i][j] += grid[i-1][j];
                if(i >0 && j > 0) grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[row-1][col-1];
    }