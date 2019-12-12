/**
 * @param {string} s
 * @return {number}
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

//dp
/**
 * @param {string} s
 * @return {number}
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

