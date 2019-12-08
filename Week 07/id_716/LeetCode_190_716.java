
public class LeetCode_190_716 {
    // you need treat n as an unsigned value
    public int reverseBits1(int n) {
        int res = 0;
        // 32 bit, loop 32 times
        for (int i = 0; i < 32; i++) {
            // n & 1： 取二进制最后一位
            // res << 1： res 左移1位，如 0 << 1 -> 00
            res = (res << 1) + (n & 1);
            // n 右移1位，删除掉最低位
            n = n >> 1;
        }
        return res;
    }
    
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);  // 和 (res << 1) + (n & 1) 等价
            n >>= 1;
        }
        return res;
    }
}