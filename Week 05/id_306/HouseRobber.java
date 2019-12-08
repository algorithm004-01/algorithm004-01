package sf.week5;

/**
 * Created by LynnSun on 2019/11/19.
 * 力扣题目地址：https://leetcode-cn.com/problems/house-robber/
 */
public class HouseRobber {
    /**
     * 打家劫舍 解法一 二维数组
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(null==nums ||0==nums.length)
            return 0;
        int len = nums.length;
        int [][]dp =new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] =dp[i-1][0]+nums[i];
        }
        return Math.max(dp[len-1][0], dp[len-1][1]);
    }

    /**
     * 打家劫舍 解法二 一维数组
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        if(null==nums ||0==nums.length)
            return 0;
        if(1==nums.length)
            return nums[0];
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int res=Math.max(dp[0], dp[1]);
        for(int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            res=Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 打家劫舍 解法三 不用数组
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
