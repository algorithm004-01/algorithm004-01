package vip.ruoyun.week7.lesson16;

public class LeetCode_191_641 {


    //利用 and 操作符
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    //每回都看看是否等于 0 如果不等于 0 那么就 and n-1 位
    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }


}
