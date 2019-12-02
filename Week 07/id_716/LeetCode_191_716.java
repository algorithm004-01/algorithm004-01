
public class LeetCode_191_716 {
    // 1. bit manipulation
    public int hammingWeight1(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    // 2. loop & mask
    public int hammingWeight2(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) res++;
            mask <<= 1;
        }
        return res;
    }

    // 3. % 2, then / 2
    public int hammingWeight3(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) res++;
            n = n >> 1;
        }

        return res;
    }
}