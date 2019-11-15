/**
 * JumpGame
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if(nums == null) return true;

        int jumpEnd = nums.length -1;
        for(int i = jumpEnd; i >= 0; i--){
            if(nums[i] + i >= jumpEnd)
                jumpEnd = i;
        }
        return jumpEnd == 0;
    }
}