/**
 * @param {string} s
 * @return {number}
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 栈和取最优解
 */
var longestValidParentheses = function(s) {
    var max = 0;
    var stack = [-1];
    for(var i = 0;i < s.length;i++){
        if(s[i] == '('){
            stack.push(i);
        }else{
            stack.pop();
            if(stack.length == 0){
                stack.push(i);
            }else{
                max = Math.max(max,i - stack[stack.length-1]);
            }
        }
    }
    return max;
};


/**
 * @param {string} s
 * @return {number}
 * 两边夹逼 直观法
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
var longestValidParentheses = function(s) {
    var max = 0;
    var left = 0;
    var right = 0;
    for(var i = 0;i < s.length;i++){
        if(s[i] == '('){
            left++;
        }else{
            right++;
        }
        if( left == right){
            max = Math.max(max,2 * left);
        }else if(right > left){
            left = right = 0;
        }
    }
    left = right = 0;
    for(var i = s.length-1;i >= 0;i--){
        if(s[i] == '('){
            left++;
        }else{
            right++;
        }
        if(left == right){
            max = Math.max(max,right * 2);
        }else if(left > right){
            left = right = 0;
        }
    }
    return max;
};


/**
 * @param {string} s
 * @return {number}
 * 动态规划
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
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
