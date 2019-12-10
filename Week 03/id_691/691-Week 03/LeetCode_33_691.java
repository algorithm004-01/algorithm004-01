class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target){
                return mid;
            }

            if(nums[start] <= nums[mid]){
                if(target < nums[mid] && target >= nums[start]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }

            if(nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }

            return -1;
        }
    }
}
