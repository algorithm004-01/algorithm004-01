class Solution {
public:
    bool canJump(vector<int>& nums) {
        if (nums.empty())
            return true;
        
        int step = nums.size() - 1;
        for (int i = nums.size() - 1; i >= 0; --i) {
            if (nums[i] + i >= step)
                step = i;
        }
        
        return step == 0;
    }
};
