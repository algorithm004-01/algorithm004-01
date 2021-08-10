class Solution {
public:
    string longestPalindrome(string s) {
        int len=s.size();
        if(len == 0 || len ==1) return s;

        int start = 0;
        int max = 1;
        vector<vector<int>> dp(len,vector<int>(len));
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
            if(i < len - 1 && s[i] == s[i+1]){
                dp[i][i+1] = 1;
                max = 2;
                start = i;
            }
        }

        for(int i=3;i <= len; i++){
            for(int j=0; i + j - 1 < len; j++){
                int end = i + j - 1;
                if(s[j]==s[end] && dp[j+1][end-1]==1)
                {
                    dp[j][end]=1;
                    start=j;
                    max=i;
                }
            }
        }

        return s.substr(start,max);
    }
};