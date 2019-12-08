class Solution {
    public int search(int[] nums, int target) {
        int minIndex = findMin(nums);
        int steps = nums.length - minIndex;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int realMid =  getRealIndex(nums.length, steps, mid);
            if(nums[realMid] < target){
                left = mid + 1;
            } else if(nums[realMid] > target) {
                right = mid - 1;
            } else {
                return realMid;
            }
        }

        return -1;
    }

    private int getRealIndex(int length, int steps, int index) {
        return (index - steps + length) % length;
    }

    private int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
                return left;
            } else if(nums[left] >= nums[mid] && nums[mid] >= nums[right]) {
                return right;
            } else if(nums[left] <= nums[mid] && nums[mid] >= nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
