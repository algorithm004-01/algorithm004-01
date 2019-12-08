import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;
import sun.net.www.content.image.gif;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {

    //bfs解法
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0){
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_length = 0;
        for(int r = 0; r < nr; r++){
            for(int c = 0; c < nc; c++){
                if(grid[r][c] == '1'){
                    num_length++;
                    grid[r][c] = '0';
                    Queue<Pair<Integer,Integer>> q = new LinkedList<>();
                    q.add(new Pair<>(r,c));
                    while(!q.isEmpty()){
                        Pair<Integer,Integer> pair = q.poll();
                        int row = pair.getKey();
                        int col = pair.getValue();

                        if(row - 1 > 0 && grid[row-1][col]=='1'){
                            q.add(new Pair<Integer,Integer>(row-1,col));
                            grid[row-1][col] = '0';
                        }
                        if(row + 1 > 0 && grid[row+1][col]=='1'){
                            q.add(new Pair<Integer,Integer>(row+1,col));
                            grid[row+1][col] = '0';
                        }
                        if(col - 1 > 0 && grid[row][col-1]=='1'){
                            q.add(new Pair<Integer,Integer>(row,col-1));
                            grid[row][col-1] = '0';
                        }
                        if(col + 1 > 0 && grid[row][col + 1] == '1'){
                            q.add(new Pair<Integer,Integer>(row,col +1));
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
            return num_length;
        }
    }

    //dfs解法
    public int numIslands2(char[][] grid) {
        if(grid == null || grid.length==0) return 0;

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        //纵向遍历
        for(int r = 0; r < nr; r++){
            //横向遍历
            for(int x = 0; x <nc; x++){
                if(grid[r][x] == '1'){
                    num_islands++;
                    dfs(grid,r,x);
                }
            }
        }
        return num_islands;
    }

    public void dfs(char[][] grid,int r,int y){
        int nr = grid.length;
        int nc = grid[0].length;
        if(r < 0 || y < 0 || r >= nr || y >= nc || grid[r][y] =='0'){
            return;
        }
        grid[r][y] = '0';
        dfs(grid, r -1, y);
        dfs(grid, r +1, y);
        dfs(grid, r, y -1);
        dfs(grid, r, y +1);
    }
}
// @lc code=end

