class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if(grid.size() == 0) return 0;
        if(grid[0].size() == 0) return 0;
        vector<vector<int> > min_num(grid.size(), vector<int>(grid[0].size(), 0));
        return minPath(grid,grid.size() - 1, grid[0].size() - 1, min_num);
    }

    int minPath(vector<vector<int>>& grid, int m, int n, vector<vector<int>>& min_num){
        if(min_num[m][n] != 0) return min_num[m][n];
        if(m == 0 && n != 0) {
            min_num[m][n] = minPath(grid, m, n - 1,min_num) + grid[m][n];
        } else if(m == 0 && n == 0) {
            min_num[m][n] = grid[m][n];
        } else if(n == 0) {
            min_num[m][n] = minPath(grid, m - 1, n,min_num) + grid[m][n];
        } else{
            min_num[m][n] = min(minPath(grid, m-1,n,min_num),minPath(grid,m,n-1,min_num)) + grid[m][n];
        }
        
        return min_num[m][n];
    }
};