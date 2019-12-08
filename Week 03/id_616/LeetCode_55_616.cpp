class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.size() < 2) return true;
        int base = nums.size() - 1;
        for(int i = base - 1; i >= 0; --i){
            if(nums[i] >= base - i){
                base = i;
            }
        }
        if(base == 0) return true;
        return false;
    }
};