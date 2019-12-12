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
        }
        for (int x = 0; x < n; ++x) {
            if (! shu.count(x) && ! pie.count(level - x) && ! na.count(x + level)) {
                cur[level][x] = 'Q';
                shu.insert(x);
                pie.insert(level - x);
                na.insert(x + level);
                solve(ret, cur, shu, pie, na, level + 1, n);
                na.erase(x + level);
                pie.erase(level - x);
                shu.erase(x);
                cur[level][x] = '.';
            }
        }
    }
};
