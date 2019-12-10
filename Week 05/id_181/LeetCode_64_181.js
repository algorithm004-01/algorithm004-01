/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
  console.log(grid)
  if (grid.length === 0) return 0;
  const len_n = grid.length;
  const len_m = grid[0].length;

  var temp = [[grid[0][0]]];
  for (let i = 1; i < len_m; i++) {
      temp[0][i]=grid[0][i] + temp[0][i-1];    
  }
  for(let i =1;i<len_n;i++) {
      temp[i] = temp[i] || []
      temp[i][0] = grid[i][0] + temp[i-1][0]
  }
  for (let n = 1; n < len_n; n++) {
      for (let m = 1; m < len_m; m++) {
          temp[n][m] = Math.min(temp[n-1][m],temp[n][m-1]) + grid[n][m]
      }
  }
  return temp[len_n-1][len_m-1]
};