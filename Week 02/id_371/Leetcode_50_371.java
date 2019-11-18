/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-27 21:34
 **/

public class Leetcode_50_371 {
    public static void main(String[] args) {
        System.out.println(myPow3(2,3));
    }


    public static double myPow3(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        return fastPow(x, n);
    }

    public static double fastPow(double x, long n) {
        //1.递归出口
        if (n == 0) {
            return 1.0;
        }
        //2.处理当前层
        double half = fastPow(x, n / 2);
        //3.带上参数,去下一层
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    /**
     * 原解2:分治(未解除-->对递归理解不够深)
     */
    public static double myPow2(double x, int n) {
        //1.递归出口
        if (n == 1) {
            return x;
        }
        //2.处理当前层
        //3.带上参数,去下一层
        //4.合并结果
        return myPow2(x, n / 2) * myPow2(x, n / 2);
    }

    /**
     * 原解1:递归*暴力法
     */
    public static double myPow1(double x, int n) {
        //1.递归出口
        if (n == 1) {
            return x;
        }
        //2.处理当前层
        //3.带上参数,去下一层
        //4.清理当前层
        return x * myPow1(x, n - 1);
    }
}
