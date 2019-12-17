class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> ret;
        if (p.size() > s.size())
            return ret;
        
        int ap[26] = {0};
        for (const auto& ch : p) ap[ch - 'a']++;
        
        int as[26] = {0};
        for (int i = 0; i < s.size(); ++i) {
            as[s[i] - 'a']++;
            if (i >= p.size())
                as[s[i - p.size()] - 'a']--;
            
            if (memcmp(ap, as, sizeof(ap)) == 0)
                ret.push_back(i - p.size() + 1);       
        }
        return ret;
    }
};
