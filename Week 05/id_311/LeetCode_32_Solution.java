class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                maxLength = Math.max(maxLength, 2 * left);
            }else if(right >= left){
                left = right = 0;
            }
        }
        left = right = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                maxLength = Math.max(maxLength, 2 * left);
            }else if(left >= right){
                left = right = 0;
            }
        }
        return maxLength;
    }
}


class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int[] dp = new int[s.length()];
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2? dp[i - 2] : 0) + 2;
                }else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] -1) == '('){
                    dp[i] = (i - dp[i - 1] -2 > 0?  dp[i - dp[i - 1] -2] : 0 ) + dp[i - 1] + 2;
                }
            }
            maxLength = Math.max(maxLength, dp[i]);

        }
        return maxLength;
    }
}