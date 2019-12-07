import java.util.*;
/**
 * 跳跃游戏
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int endIndex = nums.length - 1;
        for (int i = endIndex - 1; i >= 0; i--)
            if (nums[i] >= (endIndex - i)) endIndex = i;
        return endIndex == 0;
    }
}