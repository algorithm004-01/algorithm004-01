class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::map<int,int> m;
        vector<int> res;
        for(int i=0;i<nums.size();++i){
            auto t = m.find(nums[i]);
            if(t != m.end()){
                res.push_back(t->second);
                res.push_back(i);
                return res;
            }else{
                m.emplace(target - nums[i],i);
            }
        }
        return res;
    }
};