class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    return binarySearch(left, mid, nums, target);
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    return binarySearch(mid, right, nums, target);
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
    
    public int binarySearch(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
}