class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int j = 0;
        for (int i = 0; i != nums.size(); ++i) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                // 防止[1], [1, 0]这种输入
                if (i != j) {
                    nums[i] = 0;   
                }
                ++j;
            }
        }     
    }
};
