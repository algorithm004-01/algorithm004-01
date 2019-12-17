class Solution {
    public int findMin(int[] nums) {
        //取一个基准值,这里取最右边
        int left = 0;
        int right = nums.length - 1;
        int mid;
        
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;          
            } else {
                left = mid + 1;
            }
        }
        
        return nums[right];
    }
}
