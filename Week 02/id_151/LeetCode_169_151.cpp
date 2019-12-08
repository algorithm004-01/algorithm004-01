class Solution {
public:
    int majorityElement(vector<int>& nums) {
        if (nums.empty())
            return 0;
        map<int, int> nc, cn;
        for (const auto& n : nums) 
            nc[n]++;
        for (const auto& kv : nc) {
            cn[kv.second] = kv.first;
        }
        return cn.rbegin()->second;
    }
};
