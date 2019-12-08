public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0b0, i = 0; // for 换 while
        // res 左移不需要暂存，直接用 (res << 1)
        // | 代替 + ，使得都是位运算
        // n 无需右移后保存，每次重新移也可，故 (n >>> (i - 1))
        while (i++ < 32) res = (res << 1) | (n >>> (i - 1) & 1);
        return res;
    }
}
