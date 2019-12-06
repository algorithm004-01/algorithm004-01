/**
 * NumberOf1Bits
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int count = 0;
        //这里的代码应该是看是否等于零
        //如果将它看成二进制位的形式来看
        while(n != 0) {
            count ++;
            n = n & (n - 1);
        }
        return count;
    }
}