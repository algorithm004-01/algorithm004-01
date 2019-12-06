package medium;

/**
 * @author 潘磊明
 * @date 2019/11/6
 */
public class PowXN {
    /**
     * 分治
     * @param x
     * @param n
     * @return
     */
//    public double myPow(double x, int n) {
//        if (n == 0) return 1.0;
//        else if (n > 0) return _myPow(x, n);
//        else if (n != Integer.MIN_VALUE) return _myPow(1 / x, -n);
//        else return _myPow(1 / (x * x), -(n / 2));
//    }
//
//    private double _myPow(double x, int n) {
//        if (n == 1) return x;
//        double tmp = _myPow(x, n / 2);
//        return n % 2 == 1 ? tmp * tmp * x : tmp * tmp;
//    }

    /**
     * 精彩代码
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n){
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        if (n == 0) return 1.0;
        double tmp = myPow(x, n / 2);
        return tmp * tmp * myPow(x, n % 2);
    }
}
