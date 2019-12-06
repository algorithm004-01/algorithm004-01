class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        reveal(board,click[0],click[1]);
        return board;
    }

    bool inboard(const vector<vector<char>>& board, int x, int y){
        return ( x>=0 && x<board.size() && y>=0 && y<board[0].size() );
    }

    void reveal(vector<vector<char>>& board, int x, int y){
        if(!inboard(board,x,y)) return;
        if(board[x][y] == 'E'){
            //search 8 adjacent squares
            int count = 0;
            if(inboard(board,x-1,y-1) && board[x-1][y-1] == 'M') count++;
            if(inboard(board,x-1,y  ) && board[x-1][y  ] == 'M') count++;
            if(inboard(board,x-1,y+1) && board[x-1][y+1] == 'M') count++;
            if(inboard(board,x  ,y-1) && board[x  ][y-1] == 'M') count++;
            if(inboard(board,x  ,y+1) && board[x  ][y+1] == 'M') count++;
            if(inboard(board,x+1,y-1) && board[x+1][y-1] == 'M') count++;
            if(inboard(board,x+1,y  ) && board[x+1][y  ] == 'M') count++;
            if(inboard(board,x+1,y+1) && board[x+1][y+1] == 'M') count++;

            if(count>0)
                board[x][y] = '0'+count;
            else{
                board[x][y] = 'B';
                reveal(board,x-1,y-1);
                reveal(board,x-1,y  );
                reveal(board,x-1,y+1);
                reveal(board,x  ,y-1);
                reveal(board,x  ,y+1);
                reveal(board,x+1,y-1);
                reveal(board,x+1,y  );
                reveal(board,x+1,y+1);
            }
        }
    }
};