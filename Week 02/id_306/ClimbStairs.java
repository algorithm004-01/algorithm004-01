/**
 * Created by LynnSun on 2019/10/27.
 */
public class ClimbStairs {

    /**
     * 注意输入的层数，有可能出来的数会超过正整数的限制
     * @param n
     * @return
     */
    public int climbStairs(int n) {
//        return climb_Stairs_bl(0, n);
        int array[] = new int[n + 1];
        return climb_Stairs_array(0, n, array);
    }

    /**
     * 暴力递归方式
     * @param i
     * @param n
     * @return
     */
    private int climb_Stairs_bl(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs_bl(i + 1, n) + climb_Stairs_bl(i + 2, n);
    }

    /**
     * 优化暴力递归方式，记忆化递归
     * @param i
     * @param n
     * @return
     */
    private int climb_Stairs_array(int i, int n, int array[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        array[i] =climb_Stairs_array(i + 1, n,array) + climb_Stairs_array(i + 2, n,array);
        return array[i];
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs_dynamic(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 斐波那契
     * @param n
     * @return
     */
    public int climbStairs_fibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

}
