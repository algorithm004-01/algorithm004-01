class Solution {
private:
  void sink(vector<vector<char>>& grid, int i, int j, int high, int len) {
    grid[i][j] = '0';
    if (i - 1 >= 0 && grid[i-1][j] == '1') sink(grid, i - 1, j,high,len);
    if (i + 1 < high && grid[i+1][j] == '1') sink(grid, i + 1, j,high,len);
    if (j - 1 >= 0 && grid[i][j-1] == '1') sink(grid, i, j - 1,high,len);
    if (j + 1 < len && grid[i][j+1] == '1') sink(grid, i, j + 1,high,len);
  }

public:
  int numIslands(vector<vector<char>>& grid) {
    int high = grid.size();
    if (!high) return 0;
    int len = grid[0].size();

    int cnt = 0;
    for (int i = 0; i < high; ++i) {
      for (int j = 0; j < len; ++j) {
        if (grid[i][j] == '1') {
          sink(grid, i, j, high, len);
          ++cnt;
        }
      }
    }

    return cnt;
  }
};