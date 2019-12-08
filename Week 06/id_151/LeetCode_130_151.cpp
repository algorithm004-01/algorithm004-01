class Solution {
public:
    void solve(vector<vector<char>>& board) {
        if (board.empty() || board[0].empty())
            return;
        
        vector<int> dx = {0, 0, 1,-1};
        vector<int> dy = {1,-1, 0, 0};
        for (int y = 0; y < board.size(); ++y) {
            if (board[y][0] == 'O')
                dfs(board, y, 0, dx, dy);
            if (board[y][board[y].size()-1] == 'O')
                dfs(board, y, board[y].size()-1, dx, dy);
        }
        for (int x = 0; x < board[0].size(); ++x) {
            if (board[0][x] == 'O')
                dfs(board, 0, x, dx, dy);
            if (board[board.size()-1][x] == 'O')
                dfs(board, board.size()-1, x, dx, dy);
        }
        for (int y = 0; y < board.size(); ++y) {
            for (int x = 0; x < board[y].size(); ++x) {
                if (board[y][x] == '@')
                    board[y][x] = 'O';
                else if (board[y][x] == 'O')
                    board[y][x] = 'X';
            }
        }
    }
    
    void dfs(vector<vector<char>>& board, int y, int x, vector<int>& dx, vector<int>& dy) {
        board[y][x] = '@';
        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (ny >= 0 && ny < board.size() && nx >= 0 && nx < board[ny].size() &&
                board[ny][nx] == 'O') {
                
                dfs(board, ny, nx, dx, dy);
            }
        }
    }
};
