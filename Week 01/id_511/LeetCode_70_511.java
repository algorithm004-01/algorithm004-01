package id_511;

/**
 * @version 1.0
 * @Description: 爬楼梯
 * @author: bingyu
 * @date: 2019/10/20 18:19
 */
public class LeetCode_70_511 {


    //思路，第n个台阶先简化思路，第n级台阶有两种爬法，一个从n-1跨一步，一个是从n-2跨2步
    //可以得到一个递推公式：f(n) = f(n-1) + f(n-2)，事实上就是求"斐波那契数列"
    //方法1：递归暴力法
    public static int climbStairs(int n){
        if (n < 2) { //n小于2说明是第一个台阶了，只有一种爬法
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    //公式法：
    public static int climbStairs2(int n){
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2,n + 1);
        return (int)(fib_n / sqrt_5);
    }


    public static void main(String[] args) {
        int i = climbStairs(3);
        System.out.println(i);
    }
}
