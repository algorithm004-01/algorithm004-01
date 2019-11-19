class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if (matrix.empty() || matrix[0].empty())
            return 0;
        
        vector<vector<char>> dp(matrix.size()+1, vector<char>(matrix[0].size() + 1, 0));
        
        char m = matrix[0][0] - '0';
        for (int y = 1; y <= matrix.size(); ++y) {
            for (int x = 1; x <= matrix[y-1].size(); ++x) {
                if (matrix[y-1][x-1] == '1') {
                    dp[y][x] = min(min(dp[y-1][x], dp[y][x-1]), dp[y-1][x-1]) + 1;
                    m = max(m, dp[y][x]);
                }
            }
        }
        
        return m*m;   
    }
};
