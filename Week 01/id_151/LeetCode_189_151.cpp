class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        deque<int> d(nums.begin(), nums.end());
        for (int i = 0; i < k; ++i) {
            int tmp = d.back();
            d.pop_back();
            d.push_front(tmp);
        }
        for (int i = 0; i < d.size(); ++i) {
            nums[i] = d[i];
        }
    } 
};
