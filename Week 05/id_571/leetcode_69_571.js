/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
  let arr = Array.from(Array(m), () => Array(n).fill(1));

  for (let i = m - 2; i >= 0; i--) {
    for (let j = n - 2; j >= 0; j--) {
      arr[i][j] = arr[i + 1][j] + arr[i][j + 1];
    }
  }

  return arr[0][0];
};

uniquePaths(3, 2);
