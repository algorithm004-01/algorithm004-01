package Greedy;

public class Sprt {
    //主要有两个思路：
    //1.二分法查找
    //2.牛顿法迭代

    public int sqrt(int x) {
        long left = 0;
        long right = x / 2 + 1;
        while (left < right) {
            long mid = (left + right +1) >>> 1;
            long square = mid * mid;
            if (square > x) right = mid - 1;
            else if (square < x) left = mid;
            else return (int) mid;
        }
        return (int) left;
    }


    public int sqrt(int x) {
        long r = x / 2;
        while (r*r > x) r = (r + x/r)/2;
        return (int) r;
    }
}
