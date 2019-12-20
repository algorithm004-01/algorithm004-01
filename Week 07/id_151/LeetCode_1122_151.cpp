class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        map<int, int> counter;
        for (int i : arr1)
            counter[i]++;
        
        int pos = 0;
        for (int i = 0; i < arr2.size(); ++i)
            while (counter[arr2[i]]-- > 0)
                arr1[pos++] = arr2[i];
        for (auto& kv : counter)
            while (kv.second-- > 0)
                arr1[pos++] = kv.first;
        
        return arr1;
    }
};
