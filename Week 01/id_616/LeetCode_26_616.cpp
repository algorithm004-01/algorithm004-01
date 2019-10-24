class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() < 2) return nums.size();
        
        int len = 0;
        int j = 0;
        for(int i = 1; i < nums.size(); ++i){
            if(nums[j] != nums[i]){
                nums[++j] = nums[i];
            }
        }
        len = j+1;
        nums.resize(len);
        return len;
    }
};