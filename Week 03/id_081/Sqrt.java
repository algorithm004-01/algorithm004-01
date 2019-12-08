/**
 * Sqrt
 */
public class Sqrt {

    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x)
                right = mid - 1;
            else
                left = mid;
        }
        return (int) right;
    }
}