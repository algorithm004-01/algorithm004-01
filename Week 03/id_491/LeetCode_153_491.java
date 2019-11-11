class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
                return nums[left];
            } else if(nums[left] >= nums[mid] && nums[mid] >= nums[right]) {
                return nums[right];
            } else if(nums[left] <= nums[mid] && nums[mid] >= nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return nums[left];
    }
}
