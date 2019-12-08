class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int g_length = g.size();
        int s_length = s.size();
        
        int i = 0;
        int j = 0;
        int res = 0;

        while (i < g_length && j < s_length) {
            if (g[i] <= s[j]) {
                //可以满足胃口，把小饼干喂给小朋友
                res += 1;
                i += 1;
                j += 1;
            } else
                //不满足胃口，查看下一块小饼干
                j += 1;
        }                
        return res;
    }
};