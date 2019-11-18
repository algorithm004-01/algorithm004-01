class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int num = 0;
        for (int y = 0; y < grid.size(); ++y) {
            for (int x = 0; x < grid[y].size(); ++x) {
                if (grid[y][x] == '1') {
                    num += bomb(grid, x, y);
                }
            }
        }      
        return num;
    }
    
    int bomb(vector<vector<char>>& grid, int x, int y) {
        if (grid[y][x] == '0')
            return 0;
        
        grid[y][x] = '0';
        
        static int dx[4] = {1, -1, 0, 0};
        static int dy[4] = {0, 0, 1, -1};
        for (int i = 0; i < 4; ++i) {
            int newx = x + dx[i];
            int newy = y + dy[i];

            if (newy >= grid.size() || newx >= grid[newy].size())
                continue;
            
            bomb(grid, newx, newy);
        }
        
        return 1;
    }
};
