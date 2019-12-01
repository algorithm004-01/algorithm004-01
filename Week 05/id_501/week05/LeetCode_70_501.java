package homework.week05;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @author sintang
 * @date 2019-11-17
 */
public class LeetCode_70_501 {

    /**
     * 递归
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n -2);
    }

    /**
     * 递归优化 - 缓存
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] nums = new int[n +1];
        return clim(n,nums);
    }
    public int clim(int n,int[] nums){
        if(n <= 2){
            return n;
        }
        nums[n] = nums[n] != 0 ?  nums[n] : climbStairs2(n - 1) + climbStairs2(n -2);
        return nums[n];
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs3(int n){
       // 1、定义数组
        int[] dp = new int[n + 1];
       // 2、找出关系式 dp[n] = dp[n -1] + dp[n-2]
       // 3、初始化值
        if(n == 1){
            return 1;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i -1] + dp[i-2];
        }
        return dp[n];

    }

    public static void main(String[] args) {
        LeetCode_70_501 leetCode = new LeetCode_70_501();
        System.out.println(leetCode.climbStairs(3));
        System.out.println(leetCode.climbStairs2(3));
        System.out.println(leetCode.climbStairs3(2));
    }
}
