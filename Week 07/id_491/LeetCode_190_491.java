public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int mask = 1;
        for(int i = 0 ;i < 32; i++) {
            result = (result << 1) + (n & mask);
            n = n >> 1;
        }
        return result;
    }
}
