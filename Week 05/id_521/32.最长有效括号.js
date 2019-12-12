var longestValidParentheses = function(s) {
    var max = 0;
    var n = s.length;
    var dp = new Array(n).fill(0);
    for(var i = 1;i < n;i++){
       if(s[i] == ')'){
           if(s[i-1] == '('){
               dp[i] = ( i >= 2 ? dp[i-2] : 0) + 2;
           }
           else if(i - dp[i-1] > 0 && s[i - dp[i-1] - 1] == '('){
               dp[i] = dp[i-1] + ( (i - dp[i-1] >= 2) ? dp[i - dp[i-1] - 2] : 0 ) + 2;
           }
            max = Math.max(max,dp[i]);
       }
    }
    return max;
};