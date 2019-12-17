class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.size() == 0 || matrix[0].size() == 0) return 0;
        
        int rows = matrix.size();
        int cols = matrix[0].size();
        int max_len = 0;

        vector<vector<int> > dp(rows, vector<int>(cols, 0));

        for(int i = 0; i < rows; ++i){
            dp[i][0] = matrix[i][0] - '0';
            max_len = max(max_len,dp[i][0]);
        }

        for(int j = 0; j < cols; ++j){
            dp[0][j] = matrix[0][j] - '0';
            max_len = max(max_len,dp[0][j]);
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '1'){
                    dp[i][j] = min(min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    max_len = max(max_len, dp[i][j]);
                }
            }
        }

        return max_len * max_len;
    }
};