/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-26 17:33
 **/

public class Leetcode_70_371 {

    public static void main(String[] args) {
        //f(n) = f(n-1)+f(n-2)
        System.out.println(climbStairs1(6));

    }

    /**
     * 仿解2: 递归 + 数组缓存
     */
    public static int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return climb_stair(0, n, memo);
    }

    /**
     *
     * @param i 表示从当前层爬到第n层的各种个你可能
     * @param n 要跑到的目标层
     * @param memo 数组缓存
     * @return
     */
    private static int climb_stair(int i, int n, int[] memo) {
        //1.递归出口
        if(i >n) return 0;
        if (i == n) return 1;
        if (memo[i]>0) return memo[i]; //有缓存取缓存

        //2.处理当前层
        //3.带上参数,去下一层(每次递归调用-->爬一层或者爬两层)
        memo[i] = climb_stair(i + 1, n, memo) + climb_stair(i + 2, n, memo);

        return memo[i];
    }

    /**
     * 仿解1:动态规划  + 数组缓存
     */
    public static int climbStairs1(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 原解1.递归(斐波那契数列)
     *
     * @param n
     * @return1
     */
    public static int climbStairs(int n) {
        //1.递归出口
        if (n <= 2) {
            return n;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
