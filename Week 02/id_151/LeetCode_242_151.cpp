class Solution {
public:
    bool isAnagram(string s, string t) {
        map<char, int> m;
        
        for (const auto& ch : s) {
            m[ch]++;
        }
        
        for (const auto& ch : t) {
            if (! m.count(ch))
                return false;
            
            int& n = m[ch];
            n--;
            if (n == 0) 
                m.erase(ch);
        }
        return m.empty();
    }
};
