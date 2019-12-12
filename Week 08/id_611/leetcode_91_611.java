class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() ==0){
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 1;
        if(s.charAt(len - 1) =='0'){
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for(int i = len - 2; i >=0 ; i--){
            if(s.charAt(i)=='0'){
                dp[0] = 0;
                continue;
            } 
            if ((s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0') <= 26){
                dp[i] = dp[i+1] + dp[i+2];
            } else {
                dp[i] = dp[i+1];
            }
            
        }
        return dp[0];
    }
}