class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int num = nums[mid];
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                num = nums[mid];
            } else {
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (num < target) {
                start = mid + 1;
            } else if (num > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}