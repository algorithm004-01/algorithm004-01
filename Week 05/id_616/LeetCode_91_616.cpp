class Solution {
public:
    int numDecodings(string s) {
        if(s[0] == '0') return 0;
        if(s.size() == 1) return 1;
        int pre = 1;
        int cur = 1;
        for(int i = 1; i < s.size(); ++i){
            int t = cur;
            char tmp = s[i - 1];
            if(s[i] == '0'){
                if(tmp =='1' || tmp == '2') cur = pre;
                else return 0;
            } else if(tmp == '1' || tmp == '2' && s[i] >= '1' && s[i] <= '6') {
                cur += pre;
            }
            pre = t;
        }
        return cur;
    }
};