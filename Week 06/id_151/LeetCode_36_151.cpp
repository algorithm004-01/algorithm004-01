class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<set<char>> cols(board.size(), set<char>());
        auto rows = cols;
        auto blocks = cols;
        
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[i].size(); ++j) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (cols[j].count(ch))
                        return false;
                    cols[j].insert(ch);
                    if (rows[i].count(ch))
                        return false;
                    rows[i].insert(ch);
                    if (blocks[j / 3 * 3 + i / 3].count(ch))
                        return false;
                    blocks[j / 3 * 3 + i / 3].insert(ch);
                }
            }
        }
        return true;
    }
};
