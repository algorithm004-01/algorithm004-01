class Solution {
    public int numIslands(char[][] grid) {
        //深度优先
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for(int r = 0; r < nr; ++r){
            for(int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1'){
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }

    void dfs(char[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;

        if( r < 0 || c < 0 || r >= nr || grid[r][c] ==
                '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r ,c - 1);
        dfs(grid, r, c + 1);
    }


    //广度首先
    public int numIsland(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_island = 0;

        for(int r = 0; r < nr; ++r){
            for(int c = 0; c < nc;++c){
                if(grid[r][c] == '1'){
                    ++nums_islands;
                    grid[r][c] = '0' //mark as visited
                    Queue<Integer> neignbors = new LinkedList<>();
                    neignbors.add(r * nc + c);
                    while(!neignbors.isEmpty()){
                        int id = neignbors.remove();
                        int row = id/nc;
                        int col = id % nc;

                        if( row - 1 >= 0 && grid[row -1][col] == '1'){
                            neignbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }

                        if (row + 1 < nr && grid[row + 1][col] == '1'){
                            neignbors.add((row + 1)* nc + col);
                            grid[row + 1][col] = '0';
                        }

                        if( col - 1 >= 0 && grid[row][col -1] == '1'){
                            neignbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }

                        if( col + 1 < nc && grid[row][col + 1] == '1') {
                            neignbos.add(row * nc + col + 1);
                            grid[row][col + 1] = '0'
                        }
                    }
                }
            }
        }
    }

}
