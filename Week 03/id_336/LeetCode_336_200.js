// #### 解法一：DFS
/**
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
    function sink(i,j){
        // terminator
        if(grid[i][j] == '0'){
            return 0;
        }
        // process
        grid[i][j] = '0';
        // drill down
        if(i+1<len && grid[i+1][j] == '1'){
            sink(i+1,j);
        } 
        if(i-1 >= 0 && grid[i-1][j] == '1'){
            sink(i-1,j);
        } 
        if(j+1 < size && grid[i][j+1] == '1'){
            sink(i,j+1);
        } 
        if(j-1 >= 0 && grid[i][j-1] == '1'){
            sink(i,j-1);
        }
        return 1;
    }
    for(var i = 0;i<len;i++){
        for(var r = 0;r<grid[i].length;r++){
            if(grid[i][r] == '1'){
                island += sink(i,r);
            }
        }
    }
    return island;
};
// #### 解法二：BFS
/**
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