/*
 * @lc app=leetcode.cn id=647 lang=javascript
 *
 * [647] 回文子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function(s) {
    //方案一 索引向外扩张法
    let count = 0;
    function find(s, left, right) {
        while(left >= 0 && right < s.length && s[left] == s[right]) {
            count++;
            left--;
            right++;
        }
    }
    for(let i = 0; i < s.length; i++) {
        find(s, i, i);
        find(s, i, i+1);
    }
    return count;
    // 方案二 动态规划 (看不懂，暂放)
    // let dp = Array.from({length: s.length}, _ => new Array(s.length).fill(0));
    // for (let i = s.length-1; i >= 0; i--) {
    //     for (let j = i; j < s.length; j++) {
    //         if (j == i) dp[i][j] = true; // 只有一个字符时
    //         if (s[i] == s[j]) { // 两个及两个以上字符时
    //             if (i+1 == j) {
    //                 dp[i][j] = true; // 如果是两个字符
    //             } else if (i < s.length-1 && dp[i+1][j-1]) dp[i][j] = true; // 如果更小的回文存在
    //         }0
    //     }
    // }
    // let count = 0;
    // for (let i = s.length-1; i >= 0; i--) {
    //     for (let j = i; j < s.length; j++) {
    //         if (dp[i][j]) count++;
    //     }
    // }
    // return count;
};
// @lc code=end

