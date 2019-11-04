class Solution {
public:
    int majorityElement(vector<int>& nums) {
        map<int,int> num_map;
        int k = nums.size() / 2;
        for(auto &i: nums){
            auto &&it = num_map.find(i);
            if (it != num_map.end()){
                if(++it->second > k)
                    return it->first;
            }else{
                num_map.insert(pair<int,int>(i, 1));
            }
        }
        return nums[0];
    }
};