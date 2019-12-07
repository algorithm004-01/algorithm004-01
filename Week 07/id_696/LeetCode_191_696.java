package week07;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                num++;
            }
        mask <<= 1;
        }
        return num;
    }

    public int hammingWeight2(int n) {
        int num = 0;
        while (n != 0) {
            n &= (n - 1);
            num++;
        }
        return num;
    }
}
