class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(k == 0) return;
        k %= nums.size();
       
        std::reverse(std::begin(nums), std::end(nums));
        std::reverse(std::begin(nums), std::begin(nums)+k);
        std::reverse(std::begin(nums)+k, std::end(nums));
        
        return;
    }
};