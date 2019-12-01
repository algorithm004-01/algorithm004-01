// #### 解法：动态规划
/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    var n = grid.length;
    var m = grid[0].length;
    var dp = Array.from(new Array(n),() => new Array(m));
    for(var i = 0;i < n;i++){
        for(var j = 0;j < m;j++){
            if( i != 0 && j!= 0){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }else if(i == 0 && j!=0){
                dp[i][j] = dp[i][j-1]+grid[i][j];
            }else if(i != 0 && j==0){
                dp[i][j] = dp[i-1][j]+grid[i][j];
            }else if(i == 0 && j==0){
                dp[i][j] = grid[i][j];
            }
        }
    }
    return dp[n-1][m-1];
};