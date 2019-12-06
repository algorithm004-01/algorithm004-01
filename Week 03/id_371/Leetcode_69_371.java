/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-03 10:05
 **/

public class Leetcode_69_371 {

    public static void main(String[] args) {
//        int x = 16;
//        int x = 17;
        int x = 12;
        int res = mySqrt2(x);
        System.out.println("res = " + res);

    }

    /**
     * 仿解2:(牛顿迭代法)
     * @author Shaobo.Qian
     * @date 2019/11/3
     */
    public static int mySqrt2(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }


    /**
     * 仿解1:(二分查找)
     *
     * @author Shaobo.Qian
     * @date 2019/11/3
     */
    public static int mySqrt1(int x) {
        //确定左右边界,开根号的值在 left 到 right 之间
        long left = 0;
        long right = x / 2 + 1;//对于一个非负数n，它的平方根不会大于（n/2+1）
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = left + 1;
            }
        }
        //如果开根号不是正数,最后的值在left到right之间
        return (int) right;
    }
}
