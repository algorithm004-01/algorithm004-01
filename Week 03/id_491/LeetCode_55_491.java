class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                boolean canReach = false;
                for(int j = i - 1; j >= 0; j-- ){
                    if(nums[j] + j > i || nums[j] + j == nums.length - 1){
                        canReach = true;
                        break;
                    }
                }

                if(!canReach) {
                    return false;
                }
            }
        }

        return true;
    }
}
