/*
 * @lc app=leetcode.cn id=56 lang=javascript
 *
 * [56] 合并区间
 */

// @lc code=start
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    //暴力
    if(intervals.length <= 0) return [];
    intervals.sort( (a,b) => a[0] - b[0]);
    let i = 0;
    let n = intervals.length;
    let res = [];
    while (i < n) {
        let l = intervals[i][0];
        let r = intervals[i][1];
        while(i < n - 1 && intervals[i+1][0] <= r) {
            i++;
            r = Math.max(r, intervals[i][1]);
        }
        res.push([l,r]);
        i++;
    }
    return res;
};
// @lc code=end

