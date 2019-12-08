package homework.week05;

/**
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * @author sintang
 * @date 2019-11-17
 */
public class LeetCode_64_501 {

    public int minPathSum(int[][] grid) {
        // dp 元素表示数值和
        for (int i = 0; i < grid.length ; i++) {
            for(int j = 0; j <grid[0].length ; j++){
                if(i ==0 && j == 0){
                    continue;
                }
                if(i == 0){
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }else if(j == 0){
                    grid[i][j] = grid[i -1][j] + grid[i][j];
                }else{
                    grid[i][j] = Math.min(grid[i - 1][j],grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length -1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;
        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;
        LeetCode_64_501 leetCode = new LeetCode_64_501();
        System.out.println(leetCode.minPathSum(grid));
    }
}
