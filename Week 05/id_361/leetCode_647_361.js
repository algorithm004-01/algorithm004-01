/**
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function(s) {
    let count = 0;
    function find(s, i, j) {
        while (i >= 0 && j <s.length && s[i] == s[j]) {
            count++;
            i--;
            j++;
        }
    }
    for (let i = 0; i < s.length; i++) {
        find(s, i, i);
        find(s, i, i+1);
    }
    return count;
};

/**
 * DP
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function(s) {
    let dp = Array.from({length: s.length}, _ => new Array(s.length).fill(0));
    for (let i = s.length-1; i >= 0; i--) {
        for (let j = i; j < s.length; j++) {
            if (j == i) dp[i][j] = true; // 只有一个字符时
            if (s[i] == s[j]) { // 两个及两个以上字符时
                if (i+1 == j) {
                    dp[i][j] = true; // 如果是两个字符
                } else if (i < s.length-1 && dp[i+1][j-1]) dp[i][j] = true; // 如果更小的回文存在
            }
        }
    }
    let count = 0;
    for (let i = s.length-1; i >= 0; i--) {
        for (let j = i; j < s.length; j++) {
            if (dp[i][j]) count++;
        }
    }
    return count;
};
