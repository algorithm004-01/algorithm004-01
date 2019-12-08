class Solution {
    public int majorityElement(int[] nums) {
        return findMiddle(nums, 0, nums.length-1);
    }
    
    public int findMiddle(int[] nums, int start, int end){
        int pos = partition(nums, start, end);
        //System.out.println("pos:" + pos);
        
        if (pos == nums.length / 2){
            return nums[pos];
        }
        
        if (pos < nums.length / 2){
            return findMiddle(nums, pos+1, end);
        }
        
        return findMiddle(nums, start, pos-1);
    }
    
    public int partition(int[] nums, int start, int end){
        int pos = start;
        
        while(start < end){
            while (end > start && nums[end] >= nums[pos]) end--;
            while (end > start && nums[start] <= nums[pos]) start++;

            if (end > start){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        
        int temp = nums[pos];
        nums[pos] = nums[start];
        nums[start] = temp;
        
        return start;
        
    }
}