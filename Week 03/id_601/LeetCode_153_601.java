class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int lo = 0, hi = nums.length - 1;
	    while (lo <= hi) {
	    	
	    	if (hi - lo == 1 || hi - lo == 0) {
	    		return nums[lo] < nums[hi] ? nums[lo] : nums[hi];
	    	}
	   
	        int mid = (lo + hi) / 2;
	        
	        if (nums[lo] > nums[hi] && nums[mid] > nums[hi]) {
	        	lo = mid + 1;
	        }else{
	        	 hi = mid;
	        }
	    }
		
        return 0;
    }
}
