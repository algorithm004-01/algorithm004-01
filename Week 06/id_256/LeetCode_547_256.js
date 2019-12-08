/*
 * @lc app=leetcode.cn id=547 lang=javascript
 *
 * [547] 朋友圈
 */

// @lc code=start
/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function(M) {
    let n = M.length;
    if(n == 0){
        return 0;
    }
    let count = n;
    // 查找
    let find = (p) => {
        while( p != parent[p]){
            // 路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    let union = (p,q) => {
        let rootP = find(p);
        let rootQ = find(q);
        // 集合相交则不合并
        if(rootP == rootQ){
            return;
        }
        // 查找合并
        parent[rootP] = rootQ;
        // 求连通分量，每合并两个集合，即整体减少一个独立集合
        count--;
    }
    let parent = new Array(n);
    for(let i = 0;i < n;i++){
        parent[i] = i;
    }
    for(let i = 0;i < n;i++){
        for(let j = 0; j < n;j++){
            if(M[i][j] == 1){
                union(i,j);
            }
        }
    }
    return count;
};

