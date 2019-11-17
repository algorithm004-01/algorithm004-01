/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-03 11:35
 **/

public class Leetcode_367_371 {
    public static void main(String[] args) {
        int num = 16;
        boolean perfectSquare = isPerfectSquare2(num);
        System.out.println("perfectSquare = " + perfectSquare);
    }

    /**
     * 原解2:牛顿迭代法
     *
     * @author Shaobo.Qian
     * @date 2019/11/3
     */
    public static boolean isPerfectSquare2(int num) {
        long r = num;
        while (r * r > num) {
            r = (r + num / r) / 2;
        }
        return r * r == num;
    }
    /**
     * 原解1:二分查找法
     * @author Shaobo.Qian
     * @date 2019/11/3
     */
    public static boolean isPerfectSquare1(int num) {
        //确定左右边界
        long left = 0;
        long right = num / 2 + 1;//num开根号的值不会大于 num/2+1
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = left + 1;
            }
        }
        return false;
    }

}
