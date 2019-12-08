/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-17 11:04
 **/

public class Leetcode_198_371 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int res = rob1(nums);
        System.out.println("res = " + res);

    }

    /**
     * 仿解1:dp 方程+自底向上
     *
     * @author Shaobo.Qian
     * @date 2019/11/17
     */
    public static int rob1(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        //1.建立 dp 方程
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        //2.自底向上
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    /**
     * 原解1:dp(未解出)
     *
     * @author Shaobo.Qian
     * @date 2019/11/17
     */
    public static int rob(int[] nums) {
        //1.需要维护的状态
        //1.1 奇数节点和
        int oddSum = 0;
        //1.2偶数节点和
        int evenSum = 0;
        //2.循环+记忆化(自定向下)
        for (int i = 0; i < nums.length; i++) {
            //3.各部分子问题的解
            if (i % 2 == 0) oddSum += nums[i];
            else evenSum += nums[i];
        }
        return Math.max(oddSum, evenSum);
    }
}
