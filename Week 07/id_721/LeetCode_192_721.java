package bit;

/**
 * @author alis
 * @date 2019/12/1 5:16 PM
 * @description
 */
public class LeetCode_192_721 {
    /**
     * 颠倒二进制位
     * 1. 将给定的二进制数，由低位到高位逐个取出
     * 2. 然后通过位运算，将其放置到反转到二进制位
     * 3. 将上述结果，再次通过位运算合并在一起
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i <= 32; i++) {
            // 给定的二进制数，从低位到高位逐个取出
            int temp = n >> i; // 右移i位
            temp = temp & 1; // 取最后一位
            // 然后通过位运算，将其放置到反转后的位置
            temp = temp << (31 - i);
            res |= temp;

        }
        return res;
    }
}
