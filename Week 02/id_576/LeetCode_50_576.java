/**
 * LeetCode_50_576
 */
public class LeetCode_50_576 {
    //1. 暴力法o（n）
    public double myPow1(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++) {
            ans = ans * x;
        }
        return ans;
    }

    /*
    2. 分治法o（logn）：template: 1. terminator 2.process(split big problem) 
    3. drill down(subproblem) , merge(subresults) 4. reverse states
    */

    public double myPow2(double x, int n) {
        private double fastPow(double x, long n) {
            
        }
        
    }

    public double myPow3(double x, int n) {
        if (n == Integer.MIN_VALUE && x > 1) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow3(x * x, n / 2) : x * myPow3(x * x, n / 2);
    }
}