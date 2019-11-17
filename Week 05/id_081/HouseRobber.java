import java.util.Arrays;

public class HouseRobber {

    //当 index 为 nums.length - 1 时， 能偷盗的最大金额就是 nums[nums.length - 1];
    //当 index 为 nums.length - 2 时,  能偷盗的最大金额就是 nums[nums.length - 2];
    //index -> nums.length - 3: max = nums[index] + nums[index - 2];
    //最终让我们返回 max
    public static int rob(int[] nums) {
        int max = 0;
        int[] dp = Arrays.copyOf(nums, nums.length + 2);
        for(int i = nums.length - 1; i >= 0; i--){
            dp[i] = nums[i] + dp[i + 2];
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,1, 1, 2}));
    }
}