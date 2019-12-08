class Solution {
public:
    bool canJump(vector<int>& nums) {
        // int i = 0;
        // for (int reach = 0; i < nums.size() && i <= reach; ++i)
        //     reach = max(i + nums[i], reach);
        // return i == nums.size();
        
        if (nums.size() == 0) return false;
        int len = nums.size() - 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums[i] + i >= len)
                len = i;
        }
        return len == 0;
    }
};