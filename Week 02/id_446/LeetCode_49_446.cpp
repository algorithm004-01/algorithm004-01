class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string,vector<string> >string_map;
        for(string str : strs){
            string_map[strSort(str)].push_back(str);
        }
        vector< vector<string> >anagrams;
        for(auto p : string_map){
            anagrams.push_back(p.second);
        }
        return anagrams;
    }
private:
    string strSort(string s){
        int counts[26] = {0};
        for(char c : s){
            counts[c - 'a']++;
        }
        string res;
        for(int i = 0; i < 26 ; i++){
            res += string(counts[i], i+'a');
        }
        return res;
    }
};