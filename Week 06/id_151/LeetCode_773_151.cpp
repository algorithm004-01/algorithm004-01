class Solution {
public:
    int slidingPuzzle(vector<vector<int>>& board) {
        string s;
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[i].size(); ++j) {
                s.append(1, '0' + board[i][j]);
            }
        }
        
        map<int, vector<int>> di = {
            {0, {1,3}},
            {1, {0,2,4}},
            {2, {1,5}},
            {3, {0,4}},
            {4, {1,3,5}},
            {5, {2,4}}
        };
        
        queue<string> q;
        unordered_set<string> marker;
        q.push(s);
        int count = -1;
        while (! q.empty()) {
            ++count;
            int qs = q.size();
            
            for (int i = 0; i < qs; ++i) {
                string cur = q.front();
                q.pop();
                
                if (cur == "123450")
                    return count;
                
                if (! marker.count(cur)) {
                    marker.insert(cur);
                    
                    int zero_index = cur.find('0');
                    for (const auto& d : di[zero_index]) {                        
                        cur[zero_index] = cur[d];
                        cur[d] = '0';
                        
                        q.push(cur);
                        
                        cur[d] = cur[zero_index];
                        cur[zero_index] = '0';
                    }
                }       
            }
        }
        return -1;
    }
};
