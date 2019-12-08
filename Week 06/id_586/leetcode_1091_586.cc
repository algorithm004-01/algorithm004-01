class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        if (grid.empty() || grid[0].empty() ||
            grid[0][0] == 1 ||
            grid[grid.size()-1][grid[grid.size()-1].size()-1] == 1)
        return -1;

        queue<pair<int,int>> q;
        q.push({0, 0});

        vector<int> dx = {1, 0, 1, 1,-1,-1, 0,-1};
        vector<int> dy = {1, 1, 0,-1, 1,-1,-1, 0};

        int step = 1;
        while (! q.empty()) {
            auto v = q.front();
            q.pop();

            int x = v.first;
            int y = v.second;
            if (x == (grid[0].size() - 1) && y == grid.size() - 1)
                return step;

            if (grid[y][x] != -1) {
                grid[y][x] = -1;

                for (int n = 0; n < 8; ++n) {
                    int nx = x + dx[n];
                    int ny = y + dy[n];
                    if (nx >= 0 && nx < grid[0].size() &&
                        ny >= 0 && ny < grid.size() &&
                        grid[ny][nx] == 0) {
                        q.push({nx, ny});
                    }
                }
            }
            ++step;
        }
        return -1;
    }
};
