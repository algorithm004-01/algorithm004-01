/**
 * LeetCode_69_576
 */
public class LeetCode_69_576 {
    //1. binarySearch 
    public int mySqrt1(int x) {
        if (x==0 || x==1) {
            return x;
        }
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    //2.牛顿迭代法
    public int mySqrt2(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x/r) / 2;
        }
        return (int)r;
    }
}