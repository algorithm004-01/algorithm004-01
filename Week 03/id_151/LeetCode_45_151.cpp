class Solution {
public:
    int jump(vector<int>& nums) {
        int start = 0;
        int end = 0;
        int step = 0;
        
        while (end < nums.size() - 1) {
            ++step;
            int maxEnd = end + 1;
            for (int i = start; i <= end; ++i) {
                maxEnd = max(i + nums[i], maxEnd);
                if (maxEnd >= nums.size() - 1) {
                    return step;
                }
            }
            
            start = end + 1;
            end = maxEnd;
        }
        return step;
    }
};
