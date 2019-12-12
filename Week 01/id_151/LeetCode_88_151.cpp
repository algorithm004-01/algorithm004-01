class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        if (n <= 0)
            return;
        
        memcpy(nums1.data() + m, nums2.data(), n * sizeof(int));
		sort(nums1.begin(), nums1.begin() + m + n);
    }
};
