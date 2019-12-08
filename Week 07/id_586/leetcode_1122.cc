class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        unordered_map<int, int> m;
        for(auto it : arr1)
            m[it]++;

        vector<int> res;
        for(auto it : arr2){
            while(m[it]){
                res.push_back(it);
                m[it]--;
            }
        }
        vector<int> temp;
        for(auto it : m){
            int x = it.second;
            while(x)
                temp.push_back(it.first), x--;
        }
        sort(temp.begin(), temp.end());
        for(auto it : temp)
            res.push_back(it);
        return res;
    }
};
