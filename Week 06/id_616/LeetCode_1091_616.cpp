class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        rows = grid.size();
        cols = grid[0].size();
        
        if(grid[0][0] || grid[rows-1][cols-1]) return -1;

        queue<Node *> que;
        que.push(new Node(0,0,1));
        while(que.size()){
            auto now = que.front();
            que.pop();
            if(now->x == rows-1 && now->y == cols-1) return now->step;            
            for(int i = 0; i < 8; ++i){
                int nx = now->x + dir[i][0];
                int ny = now->y + dir[i][1];
                if(nx < 0 || nx >= rows || ny < 0 || ny >= cols || grid[nx][ny])
                    continue;
                que.push(new Node(nx, ny, now->step+1));
                grid[nx][ny] = 1;
            }
        }
        return -1;
    }
private:
    struct Node{
        int x, y;
        int step;
        Node(int _x, int _y, int _s):x(_x),y(_y),step(_s){}
    };
    int rows, cols;
    int dir[8][2] = {
        {0,1},
        {1,1},
        {1,0},
        {1,-1},
        {-1,0},
        {-1,-1},
        {0,-1},
        {-1,1}
    };
};