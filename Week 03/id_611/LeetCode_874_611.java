import java.util.Set;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<String>();
        for(int[] o : obstacles)
            set.add(o[0] + " " + o[1]);
        int max =0, x = 0,y = 0,dir = 0,dirs[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int c :commands){
            if(c == -2)
                dir = dir == 0 ? 3 : dir - 1;
            else if(c == -1)
                dir = dir == 3 ? 0 : dir + 1;
            else{
                int[] xy = dirs[dir];
                while(c-- > 0 && !set.contains((x + xy[0]) + " " + (y + xy[1]))){
                    x += xy[0];y += xy[1];
                }
            }
            max = Math.max(max, x *x + y * y);
        }
       
        return max;
    }

}
// @lc code=end

