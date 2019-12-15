/**
 *  颠倒32 位无符号整数的二进制位
 *
 */
public class LeetCode_190_076 {

    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int cur = n & 1;
            res += (cur << 31 - i);

            n >>= i;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_190_076 leetCode = new LeetCode_190_076();
        int res = leetCode.reverseBits(1);
        System.out.println(res);
    }
}
