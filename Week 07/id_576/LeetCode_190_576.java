/**
 * LeetCode_190_576
 */
public class LeetCode_190_576 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 由低到高位逐个取出
            int tmp = n >> i;
            // 取有效位
            tmp = tmp & 1;
            // 通过位运算将其放置到反转后的位置
            tmp = tmp << (31 - i);
            // 将上述结果再次结合到一起
            res |= tmp;
        }
        return res;
    }
}