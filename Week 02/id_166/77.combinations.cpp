class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> results;
        helper(0,n,k,vector<int>(),results);
        return results;
    }
    
    void helper(int index,int n,int k, vector<int> result, vector<vector<int>>& results) {
        if (result.size() == k) {
            results.push_back(result);
            return;
        }
        index++;
        for(int i=index; i <= n ; i++) {
            vector<int> newResult(result);
            newResult.push_back(i);
            helper(i,n,k,newResult,results);
            
        }
        return;
    }
};