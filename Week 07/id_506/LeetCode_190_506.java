public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int i = 0;
        for (int index = 0; index < 32; index++){

            i = i << 1;
            if ((n & 1) == 1){
                i ++;
            }

            n = n >> 1;
        }

        return i;
    }
}