class Leetcode_33_436 {
    public int search(int[] nums, int target) {
        int start = 0; int end = nums.length - 1;
        if(nums.length == 0 || nums == null){
            return -1;
        }
        int mid = 0;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //判断具体位置，看看是在排序好的部分还是翻转后的部分
            if(nums[start] < nums[mid]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid;
                }
                else{
                    start = mid;
                }
            }
            else{
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
        }
            if(nums[start] == target){
                return start;
            }
            if(nums[end] == target){
                return end;
            }
                return -1;
    }
}