class Solution {
public:
    int longestValidParentheses(string s) {
        vector<int> dp(s.size(), 0);
        int res = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == ')') {
                if (i - 1 >= 0 && s[i-1] == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i-2] : 0) + 2;
                } else if (i - 1 >= 0 && s[i-1] == ')') {
                    int idx = i - dp[i-1] - 2;
                    if (idx + 1>= 0 && s[idx+1] == '(') {
                        dp[i] = dp[i-1] + (idx >= 0 ? dp[idx] : 0) + 2;
                    }
                }
                
                res = max(res, dp[i]);
            }
        }
        
        return res;
    }
};
