class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> ret;
        vector<string> cur(n, string(n, '.'));
        set<int> shu, pie, na;
        solve(ret, cur, shu, pie, na, 0, n);
        return ret;
    }
    
    void solve(vector<vector<string>>& ret, vector<string>& cur, 
        set<int>& shu, set<int>& pie, set<int>& na, int level, int n) {
        if (level == n) {
            ret.push_back(cur);
            return;
        }
        for (int y = level; y < n; ++y) {
            for (int x = 0; x < n; ++x) {
                if (! shu.count(x) && ! pie.count(y - x) && ! na.count(x + y)) {
                    cur[y][x] = 'Q';    
                    shu.insert(x);
                    pie.insert(y - x);
                    na.insert(x + y);
                    solve(ret, cur, shu, pie, na, level + 1, n);
                    na.erase(x + y);
                    pie.erase(y - x);
                    shu.erase(x);
                    cur[y][x] = '.';    
                }
            }
        }
    }
};
