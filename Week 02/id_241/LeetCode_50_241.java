import java.util.*;
/**
 * Pow(x, n)
 */
public class Solution {
    /**
     * Pow(x, n)
     */
    public double myPow(double x, int n) {
        double result = myPowHelper(x, Math.abs(n));
        return n > 0 ? result : 1 / result;
    }

    private double myPowHelper(double x, long n) {
        if (n == 0)
            return 1;
        double result = myPowHelper(x, n / 2);
        if (n % 2 == 0) {
            result = result * result;
        } else {
            result = result * result * x;
        }
        return result;
    }
}