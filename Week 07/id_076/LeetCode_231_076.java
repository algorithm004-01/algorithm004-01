/**
 *  判断是否2的幂次方
 *  2的幂次方， n & (n - 1) == 0
 */
public class LeetCode_231_076 {

    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }

        if((n & (n - 1)) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LeetCode_231_076 leetCode = new LeetCode_231_076();
        boolean flag = leetCode.isPowerOfTwo(3);
        System.out.println(flag);
    }
}
