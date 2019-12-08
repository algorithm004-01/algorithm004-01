class Solution {
public:
    void rotate(vector<int>& nums, int k) {

        k = k % nums.size();
        int len = nums.size();

        while (k > 0 && len > 1 && len != k) {
            for (int i = len - 1; i > k - 1; i--) {
                swap(nums[i], nums[i - k]);
            }

            int tmp = k;
            k = k - len % k;
            len = tmp;
        }

    }

};
