class Solution {
public:
    int numDecodings(string s) {
        if (s.empty() || s[0] == '0')
            return 0;
            
        vector<int> dp(s.size(), 1);
        for (int i = 0; i < s.size(); ++i) {
            if (i - 1 >= 0) {                
                string tmp(s, i-1, 2);
                if (tmp == "00") 
                    return 0;
                if (s[i] == '0') {
                    dp[i-1] = 0;
                }
                //cout << "tmp=" << tmp << endl;
                if (atoi(tmp.c_str()) <= 26) {
                    if (i - 2 >= 0) {
                        dp[i] = dp[i-1] + dp[i-2];
                    } else {
                        dp[i] = dp[i-1] + 1;
                    }
                } else {
                    dp[i] = dp[i-1];
                }
            }
        }
        
        return dp[s.size()-1];
    }
};
