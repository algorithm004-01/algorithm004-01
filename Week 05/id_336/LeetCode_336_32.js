// #### 解法：动态规划
/**
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
    var max = 0;
    var n = s.length;
    var dp = new Array(n).fill(0);
    for(var i = 1;i < n;i++){
       if(s[i] == ')'){
           // 右括号前边是左括号
           if(s[i-1] == '('){
               dp[i] = ( i >= 2 ? dp[i-2] : 0) + 2;
           }
           // 当前右括号前边是右括号，并且前一个合法子序列的前边是左括号和当前右括号组成一对，则最长子序列个数加2
           else if(i - dp[i-1] > 0 && s[i - dp[i-1] - 1] == '('){
               dp[i] = dp[i-1] + ( (i - dp[i-1] >= 2) ? dp[i - dp[i-1] - 2] : 0 ) + 2;
           }
            max = Math.max(max,dp[i]);
       }
    }
    return max;
};