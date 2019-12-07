/**
 * HouseRobberII
 */
import java.util.Arrays;

public class HouseRobberII {

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(_rob(Arrays.copyOfRange(nums, 0, nums.length - 1)), 
                        _rob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int _rob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}