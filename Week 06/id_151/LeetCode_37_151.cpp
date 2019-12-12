class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        solve(board);
    }
    
    bool solve(vector<vector<char>>& board) {
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[i].size(); ++j) {
                if (board[i][j] != '.')
                    continue;
                
                for (int k = 1; k <= 9; ++k) {
                    char ch = '0' + k;
                    if (valid(board, i, j, ch)) {
                        board[i][j] = ch;
                        if (solve(board))
                            return true;
                        board[i][j] = '.';
                    }                                                                
                }                
                return false;
            }
        }
        return true;
    }
    
    bool valid(vector<vector<char>>& board, int i, int j, char ch) {
        for (int n = 0; n < 9; ++n) {
            if (board[i][n] == ch)
                return false;
            if (board[n][j] == ch)
                return false;
            if (board[i / 3 * 3 + n / 3][j / 3 * 3 + n % 3] == ch)
                return false;
        }
        return true;    
    }
};
