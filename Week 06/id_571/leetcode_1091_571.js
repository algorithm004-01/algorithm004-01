/**
 * @param {number[][]} grid
 * @return {number}
 */
var shortestPathBinaryMatrix = function(grid) {
  //BFS
  let que = new Array();
  let len = 1;
  que.push({ i: 0, j: 0 });

  while (que.length > 0) {
    let i = 0,
      end = que.length,
      temp;
    let q = new Array();
    while (i < end) {
      temp = que[i];
      if (
        temp.i < 0 ||
        temp.j < 0 ||
        temp.i >= grid.length ||
        temp.j >= grid.length ||
        grid[temp.i][temp.j] == 1
      ) {
        i++;
        continue;
      }
      if (temp.i == grid.length - 1 && temp.j == grid.length - 1) return len;
      q.push({ i: temp.i, j: temp.j + 1 });
      q.push({ i: temp.i, j: temp.j - 1 });
      q.push({ i: temp.i + 1, j: temp.j });
      q.push({ i: temp.i + 1, j: temp.j + 1 });
      q.push({ i: temp.i + 1, j: temp.j - 1 });
      q.push({ i: temp.i - 1, j: temp.j });
      q.push({ i: temp.i - 1, j: temp.j + 1 });
      q.push({ i: temp.i - 1, j: temp.j - 1 });

      grid[temp.i][temp.j] = 1; //block back entry to itself
      i++;
    }
    que = q;
    len++;
  }
  return -1;
};
/*

*/
