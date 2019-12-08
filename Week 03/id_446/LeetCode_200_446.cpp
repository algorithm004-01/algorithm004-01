class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int row = grid.size();
        if(row == 0) return 0;
        int col = grid[0].size();
        int islands = 0;
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(grid[i][j] == '1') islands++;
                dfs(grid, i, j);
            }
        }
        return islands;
    }
    
    void dfs(vector<vector<char>>& grid, int i, int j){
        int row = grid.size();
        int col = grid[0].size();
        if((i < 0) || (j < 0) || (i >= row) || (j >= col) || (grid[i][j] == '0')) return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i , j - 1);
        dfs(grid, i , j + 1);
    }
};