class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        int index = -1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 左半边有序
            if (nums[0] <= nums[mid]) {
                if (target > nums[mid] || target < nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else { // 右半边有序
                if (target > nums[mid] && target < nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        
        return left == right && nums[left] == target ? left : -1;
    }
};
