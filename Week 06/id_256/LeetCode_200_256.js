/*
 * @lc app=leetcode.cn id=200 lang=javascript
 *
 * [200] 岛屿数量
 */

// @lc code=start
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    // 方案一：DFS
    // if(!grid) return 0;
    // let count = 0;
    // let m = grid.length;
    // if(m == 0) return 0;
    // let n = grid[0].length;
    // if(n == 0) return 0;
    // for(let i = 0; i < grid.length; i++) {
    //     for(let j = 0; j < grid[i].length; j++) {
    //         if(grid[i][j] == "1") {
    //             count++;
    //             lankfill(i, j, grid);
    //         }
    //     }
    // }
    // return count;
    // 方法二: 并查集
    let m = grid.length;
    if(m == 0) return 0;
    let n = grid[0].length;
    if(n == 0) return 0;
    let count = 0;
    let parent = [];
    let rank = [];
    let find = (p) => {
        if(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    let union = (p, q) => {
        let rootp = find(p);
        let rootq = find(q);
        if(rootp == rootq) return;
        if(rank[rootp] > rank[rootq]) {
            parent[rootq] = rootp;
        }else if(rank[rootq] > rank[rootp]) {
            parent[rootp] = rootq;
        }else{
            parent[rootp] = rootq;
            rank[rootq]++;
        }
        count --;
    }
    for(let i = 0; i < m; i++) {
        for(let j = 0; j < n; j++) {
            if(grid[i][j] == 1) {
                parent[i * n + j] = i * n + j;
                count ++;
            }
            rank[i * n + j] = 0;
        }
    }
    for(let i = 0; i < m; i++) {
        for(let j = 0; j < n; j++) {
            if(grid[i][j] == 1) {
                grid[i][j] = 0;
                i-1>=0 && grid[i-1][j] == 1 && union(i*n + j,(i-1)*n + j);
                j-1>=0 && grid[i][j-1] == 1 && union(i*n + j,i*n + j-1);
                i+1<m && grid[i+1][j] == 1 && union(i*n + j,(i+1)*n + j);
                j+1<n && grid[i][j+1] == 1 && union(i*n + j,i*n + j+1);
            }
        }
    }
    return count;
};
// 根据索引填埋其右、下岛屿
// let lankfill = function(i, j, grid) {
//     let ni = grid.length;
//     let nj = grid[i].length;
//     if(i == grid.length || j == grid[0].length) return;
//     grid[i][j] = "0";
//     if(i+1 < ni && grid[i+1][j] == "1") lankfill(i+1, j, grid);
//     if(j+1 < nj && grid[i][j+1] == "1") lankfill(i, j+1, grid);
//     if(i-1 >= 0 && grid[i-1][j] == "1") lankfill(i-1, j, grid);
//     if(j-1 >= 0 && grid[i][j-1] == "1") lankfill(i, j-1, grid);
//     return;
// }
// @lc code=end

