class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
         std::unordered_map<int, int> mp;

        for (int i = 0; i < nums.size(); ++i) {
            int diff = target - nums[i];
            if (mp.count(diff) == 1) {
                return std::vector<int>({mp[diff], i});
            }

            mp[nums[i]] = i;
        }

        return vector<int>({-1, -1});
    }
};
