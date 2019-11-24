class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
    /*
    i. 子问题   m(x,y) = grid[x][y] + min(m(x-1,y), m(x,y-1))
    ii. 状态定义  dp[x][y] 从前面到这个位置的最小值
    iii. DP方程   m(x,y) = grid[x][y] + min(m(x-1,y), m(x,y-1))
    */
        if (grid.empty() || grid[0].empty())
            return 0;
        auto dp = grid;
        for (int y = 1; y < dp.size(); ++y)
            dp[y][0] = dp[y-1][0] + grid[y][0];
        for (int x = 1; x < dp[0].size(); ++x)
            dp[0][x] = dp[0][x-1] + grid[0][x];
        
        if (grid[0].size() == 1)
            return dp[grid.size()-1][0];
        
        for (int y = 1; y < grid.size(); ++y) {
            for (int x = 1; x < grid[y].size(); ++x) {
                dp[y][x] = grid[y][x] + min(dp[y-1][x], dp[y][x-1]);
            }
        }
        
        return dp[grid.size()-1][grid[0].size()-1];
    }
};
