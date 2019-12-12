import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {

    //bfs解法
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0],col = cell[1];
            if(board[row][col]=='M'){
                board[row][col] = 'X';
            }else{
                int count = 0;
                for(int i = -1; i < 2; i++){
                    for(int j = -1; j <2; j++){
                        if(i==0 && j==0)continue;
                        int r = row + i,c = col + j;
                        if(r < 0 || r >= m || c < 0 || c >= n)continue;
                        if(board[r][c]=='M' || board[r][c]=='X') count++;
                    }
                }
                
                if(count>0){
                    board[row][col]=(char)(count + '0');
                }else{
                    //一定要给当前值赋值
                    board[row][col] = 'B';
                    for(int i = -1; i < 2; i++){
                        for(int j = -1; j < 2; j++){
                            if(i==0 && j==0)continue;
                            int r = row + i,c = col + j;
                            if(r < 0 || r>= m || c < 0 || c >=n )continue;
                            if(board[r][c]=='E'){
                                queue.add(new int[]{r,c});
                                board[r][c]='B';
                            }
                        }
                    }
                }
            }
            
        }
        return board;
    }

    //dfs解法
    public char[][] updateBoard1(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0],col = click[1];

        if(board[row][col] =='M'){
            board[row][col] ='X';
        } else {
            //计算附近地雷数量
            int count = 0;
            for(int i = -1; i < 2; i++){
                for(int j = -1; j < 2; j++){
                    if(j==0 && i==0)continue;
                    int r = row + i, c = col + j;
                    if(r < 0 || r >= m || c < 0 || c >= n) continue;
                    if(board[r][c] == 'M' || board[r][c] == 'X' ) count++;
                }
            }
            //填充数量
            if(count>0){
                board[row][col] = (char)(count + '0');
            }else{
                board[row][col] = 'B';
                for(int i = -1; i < 2; i++){
                    for(int j = -1; j < 2; j++){
                        if(i==0 && j==0) continue;
                        int r = row + i,c = col + j;
                        if(r<0 || r >= m || c <0 || c >= n)continue;
                        if(board[r][c] == 'E') updateBoard(board, new int[]{r,c});
                    }
                }
            }
        }
        return board;
    }
}
// @lc code=end

