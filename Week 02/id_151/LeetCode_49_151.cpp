class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ret;
        map<int, vector<string>> m;
        for (const auto& str : strs) {
            auto tmp = str;
            sort(tmp.begin(), tmp.end());
            m[hash<string>{}(tmp)].push_back(str);
        }
        for (const auto& kv : m) {
            ret.push_back(kv.second);
        }
        return ret;
    }
};
