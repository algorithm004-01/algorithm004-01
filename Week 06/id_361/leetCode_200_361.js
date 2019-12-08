//leetCode 200. 岛屿数量


/**
 * 解法1：DFS flood fill
 * 时间复杂度 :O(M×N)，其中 MM 和 NN 分别为行数和列数。
 * 空间复杂度 :O(M×N)，此时整个网格均为陆地，深度优先搜索的深度达到 M×N
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
    if (grid == null || grid.length == 0) {
        return 0;
    }

    var nr = grid.length;
    var nc = grid[0].length;
    var num_islands = 0;
    for (var r = 0; r < nr; ++r) {
        for (var c = 0; c < nc; ++c) {
            if ('1' === grid[r][c]) { //if 1 begin dfs
                ++num_islands;
                dfs(grid, r, c);
            }
        }
    }

    return num_islands;
}

/**
 * 解法2-dfs算法
 * @param grid
 * @param r
 * @param c
 */
function dfs(grid, r, c) {
    var nr = grid.length;
    var nc = grid[0].length;

    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
        return;
    }
    grid[r][c] = '0'; //  flood fill
    //4 directions
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1);
}

////////////////////////////////////////////////////////////////////////////
/**
 * 解法3：DFS
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    if(!grid || grid.length == 0){
        return 0;
    }
    var len = grid.length;
    var size = grid[0].length;
    var island = 0;
    // 从右到左 队列
    var queue = [];
    // 方向向量
    var dx = [-1,1,0,0];
    var dy = [0,0,-1,1];
    // dfs 推平
    function sink(i,j){
        // terminator
        if(grid[i][j] == '0'){
            return 0;
        }
        // process
        grid[i][j] = '0';
        // drill down
        for(var k = 0;k< dx.length;k++){
            var x = i + dx[k];
            var y = j + dy[k];
            if(x >= 0 && x < grid.length && y >=0 && y<grid[i].length){
                if(grid[x][y] == '1'){
                    queue.push([x,y]);
                }
            }
        }
        return 1;
    }
    for(var i = 0;i<len;i++){
        for(var r = 0;r<grid[i].length;r++){
            if(grid[i][r] == 1){
                island++;
                queue.push([i,r])
                while(queue.length>0){
                    var tmpIsland = queue.shift();
                    sink(tmpIsland[0],tmpIsland[1]);
                }
            }
        }
    }
    return island;
};

