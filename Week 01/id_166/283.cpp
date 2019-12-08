class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        for (int lastNZeroFoundAt = 0, cur = 0; cur < nums.size(); cur++) {
            if (nums[cur] != 0) {
                swap(nums[lastNZeroFoundAt++], nums[cur]);
            }
        }
    }
};
