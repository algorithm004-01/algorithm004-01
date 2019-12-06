/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-26 19:03
 **/

public class Leetcode_231_371 {
    public static void main(String[] args) {
        boolean res = isPowerOfTwo(8);
        System.out.println("res = " + res);
    }

    public static boolean isPowerOfTwo(int n) {

        return n > 0 && (n & (n - 1)) == 0;
    }
}
