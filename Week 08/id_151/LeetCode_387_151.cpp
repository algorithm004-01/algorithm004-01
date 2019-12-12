class Solution {
public:
    int firstUniqChar(string s) {
        int a[26] = {0};
        
        for (const auto& ch : s)
            a[ch - 'a']++;
        
        for (int i = 0; i < s.size(); ++i)
            if (a[s[i] - 'a'] == 1)
                return i; 
        return -1;
    }
};
