package sf.week5;

/**
 * Created by LynnSun on 2019/11/18.
 * 力扣题目地址：https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    /**
     * 动态规划方式
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
