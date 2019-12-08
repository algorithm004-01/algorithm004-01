class Solution {
public:
    int reversePairs(vector<int>& nums) {
        if (nums.empty())
            return 0;
        
        int ret = mergeSort(nums, 0, nums.size() - 1); 
        for (const auto& n : nums) cout << n << ",";
        return ret;
    }
    
    int mergeSort(vector<int>& nums, int left, int right) {
        if (left >= right)
            return 0;
        
        int mid = left + ((right - left) >> 2);
        int r1 = mergeSort(nums, left, mid);
        int r2 = mergeSort(nums, mid + 1, right);
        
        int r3 = merge(nums, left, mid, right);
        
        return r1 + r2 + r3;
    }
    
    int merge(vector<int>& nums, int left, int mid, int right) {
        int ret = 0;
        int i = left;
        int j = mid + 1;
        int k = 0;
        
        for (int l = left, m = mid + 1; l <= mid; ++l) {
            while (m <= right && nums[l] > 2L * nums[m])
                ++m;
            // 因为左边是升序的, 所以要+=, 而不能把++ret放到上面去
            ret += m - j;
        }
        
        vector<int> tmp(right - left + 1, 0);
        while (i <= mid && j <= right)
            tmp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        
        while (i <= mid) 
            tmp[k++] = nums[i++];
        
        while (j <= right)
            tmp[k++] = nums[j++];
        
        copy(tmp.begin(), tmp.end(), nums.begin() + left);
        return ret;
    }
};
