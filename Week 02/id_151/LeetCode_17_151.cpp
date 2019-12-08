class Solution {
private:
    map<char, string> numToLetter = {
        {'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"},
        {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}
    };
    
public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty())
            return {};
        
        string one_solution;
        vector<string> res;
        _dfs(0, digits, one_solution, res);
        return res;
    }
    
    void _dfs(int level, string digits, string& one_solution, vector<string>& res) {
        if (level == digits.size()) {
            res.push_back(one_solution);
            return;
        }
        
        char cur = digits[level];
        string letter = numToLetter[cur];
        
        for (const auto& ch : letter) {
            one_solution += ch;
            _dfs(level + 1, digits, one_solution, res);
            one_solution = one_solution.erase(one_solution.size() - 1, 1);
        }
    }
};
