import java.util.*;
/**
 * 颠倒二进制位
 */
class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int last = n & 1;
            n >>= 1;
            ans = ans | (last << (31 - i));
        }
        return ans;
    }
}